package com.kirkiki.customspinneradapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<String> {

  private List<String> objects;
  private Context context;

  private int type;

  public CustomArrayAdapter(Context context, int resourceId, List<String> objects, int type) {
    super(context, resourceId, objects);
    this.objects = objects;
    this.context = context;
    this.type = type;
  }

  @Override public View getDropDownView(int position, View convertView, ViewGroup parent) {
    return getCustomView(position, convertView, parent);
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    return getCustomView(position, convertView, parent);
  }

  public View getCustomView(int position, View convertView, ViewGroup parent) {

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View row;
    if (type == 0) {
      row = inflater.inflate(R.layout.spinner_item, parent, false);
    } else {
      row = inflater.inflate(R.layout.adapter_list_template, parent, false);
    }

    TextView label = (TextView) row.findViewById(R.id.tv_test);
    label.setText(objects.get(position));



    return row;
  }
}
