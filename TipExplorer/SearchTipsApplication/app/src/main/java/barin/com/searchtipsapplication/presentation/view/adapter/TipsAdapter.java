package barin.com.searchtipsapplication.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import barin.com.searchtipsapplication.R;
import barin.com.searchtipsapplication.application.util.AppUtil;
import barin.com.searchtipsapplication.data.entity.Tip;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.TipViewHolder> {

  public interface OnItemClickListener {
    void onUserItemClicked(Tip tip);
  }

  private List<Tip> mTips;
  private final LayoutInflater layoutInflater;
  private OnItemClickListener onItemClickListener;

  @Inject public TipsAdapter(Context context) {
    this.layoutInflater =
        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.mTips = Collections.emptyList();
  }

  @Override public int getItemCount() {
    return (this.mTips != null) ? this.mTips.size() : 0;
  }

  @Override public TipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View view = this.layoutInflater.inflate(R.layout.item_list_content, parent, false);
    return new TipViewHolder(view);
  }

  @Override public void onBindViewHolder(TipViewHolder holder, final int position) {
    final Tip tip = this.mTips.get(position);

    holder.textViewTipDate.setText(AppUtil.getReadableDate(tip.getCreatedAt()));
    holder.textViewTipText.setText(tip.getText());

    holder.itemView.setOnClickListener(v -> {
      if (TipsAdapter.this.onItemClickListener != null) {
        TipsAdapter.this.onItemClickListener.onUserItemClicked(tip);
      }
    });
  }

  @Override public long getItemId(int position) {
    return position;
  }

  public void setTipCollection(Collection<Tip> tips) {
    this.validateUsersCollection(tips);
    this.mTips = (List<Tip>) tips;
    this.notifyDataSetChanged();
  }

  public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
    this.onItemClickListener = onItemClickListener;
  }

  private void validateUsersCollection(Collection<Tip> tips) {
    if (tips == null) {
      throw new IllegalArgumentException("The list cannot be null");
    }
  }

  static class TipViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.tip_date) TextView textViewTipDate;
    @Bind(R.id.tip_text) TextView textViewTipText;

    public TipViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
