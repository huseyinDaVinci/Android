package com.kirkiki.customspinneradapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Spinner spinner1 = (Spinner) findViewById(R.id.spn_templates_1);
    Spinner spinner2 = (Spinner) findViewById(R.id.spn_templates_2);

    spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(getClass().getSimpleName(), "selected...");
      }

      @Override public void onNothingSelected(AdapterView<?> adapterView) {

      }
    });

    List<String> list = new ArrayList<String>() {{
      add("A");
      add("B");
      add("C");
    }};

    ArrayAdapter<String> templatesAdapter1 = new CustomArrayAdapter(this, R.layout.spinner_item, list, 0);
    spinner1.setAdapter(templatesAdapter1);

    ArrayAdapter<String> templatesAdapter2 = new CustomArrayAdapter(this, R.layout.adapter_list_template, list, 1);
    spinner2.setAdapter(templatesAdapter2);
  }
}
