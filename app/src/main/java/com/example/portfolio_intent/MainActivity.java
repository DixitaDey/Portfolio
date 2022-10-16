package com.example.portfolio_intent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_DETAILS = 1337;
    private static final String TAG = "MainActivity";
    private  String githubSearch = null;
    ActivityResultLauncher<Intent> startforResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode()!=REQUEST_CODE_DETAILS && result.getResultCode()==RESULT_OK && result.getData()!=null)
            {
                //receive data
                PortFolio portFolio=result.getData().getParcelableExtra(EnterData.PARAM_PORTFOLIO);
                //double check
                if(portFolio!=null)
                    setData(portFolio);
            }
        }
    });

    public void setData(PortFolio portFolio) {
        //set data
        TextView name=findViewById(R.id.textView);
        TextView pos=findViewById(R.id.textView2);
        TextView title=findViewById(R.id.textView4);
        TextView course_n=findViewById(R.id.textView5);
        TextView yr1=findViewById(R.id.textView6);
        TextView org=findViewById(R.id.textView8);
        TextView yr2=findViewById(R.id.textView10);
        TextView course_name=findViewById(R.id.textView9);

        name.setText(portFolio.getName());
        pos.setText(portFolio.getPosition());
        title.setText(portFolio.getEducation().getTitle());
        course_n.setText(portFolio.getEducation().getDegree());
        yr1.setText(portFolio.getEducation().getE_year());
        course_name.setText(portFolio.getCourse().getC_name());
        yr2.setText(portFolio.getCourse().getC_year());
        org.setText(portFolio.getCourse().getOrganization());

        //setGithub username
        //String abc=portFolio.getGithubUsername();
        githubSearch=String.valueOf(portFolio.getGithubUsername());

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton addActionButton =(FloatingActionButton) findViewById(R.id.action);
        addActionButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,EnterData.class);
                //startActivityForResult(intent,REQUEST_CODE_DETAILS);
                startforResult.launch(intent);
            }
        });
    }


    public void OpenGithub(View view) {
        String GithubUrl="https://github.com/";
        if(githubSearch!=null)
        {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(GithubUrl+githubSearch));
            startActivity(intent);
        }
        else
        {
            Toast.makeText(MainActivity.this,"No GitHub username found",Toast.LENGTH_SHORT).show();
        }

    }
}