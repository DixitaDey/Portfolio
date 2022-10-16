package com.example.portfolio_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterData extends AppCompatActivity {
    public static final String PARAM_PORTFOLIO="sisha";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);
    }

    public void Submitdata(View view) {
        EditText etname=findViewById(R.id.editTextTextPersonName);
        EditText etposition=findViewById(R.id.editTextTextPersonName2);
        EditText ettitle=findViewById(R.id.editTextTextPersonName3);
        EditText etdeg=findViewById(R.id.editTextTextPersonName4);
        EditText eteyear=findViewById(R.id.editTextTextPersonName5);
        EditText orgname=findViewById(R.id.editTextTextPersonName6);
        EditText cname=findViewById(R.id.editTextTextPersonName7);
        EditText cyear=findViewById(R.id.editTextTextPersonName8);
        EditText github=findViewById(R.id.editTextTextPersonName9);
        if(etname.getText().toString().isEmpty()|| etname.getText().toString()==null)
        {
            etname.setError("Valid Name is mandatory");
            etname.requestFocus();
        }
        Education education=new Education(ettitle.getText().toString(),etdeg.getText().toString(),eteyear.getText().toString());
        Course course=new Course(orgname.getText().toString(),cname.getText().toString(),cyear.getText().toString());
        PortFolio portFolio=new PortFolio(etname.getText().toString(),etposition.getText().toString(), course, education,github.getText().toString());

        Intent intent=new Intent();
        intent.putExtra(PARAM_PORTFOLIO,portFolio);
        setResult(RESULT_OK,intent);
        finish();
    }
}