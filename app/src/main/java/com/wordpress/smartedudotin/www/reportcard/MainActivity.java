package com.wordpress.smartedudotin.www.reportcard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String SHARED_PREFS_FILE = "sharedPreferenceFile";
    private static final String TASKS = "reportCards" ;
    private EditText mName, mPhysicsMarks, mMathMarks, mChemMarks;

    @SuppressLint("StaticFieldLeak")
    public static Repository repository = new Repository ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        //Calling all views
        mName = findViewById (R.id.student_name);
        mPhysicsMarks = findViewById (R.id.physics_marks);
        mMathMarks = findViewById (R.id.math_marks);
        mChemMarks = findViewById (R.id.chemistry_marks);

        Button saveBtn = findViewById (R.id.save_report);

        // to give Context to all methods in Repository
        repository.setContext (MainActivity.this);

        saveBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                repository.SaveReportCard (mName.getText ()+"",
                        ""+mPhysicsMarks.getText (),
                        ""+mMathMarks.getText (),
                        ""+mChemMarks.getText ());

            }
        });

    }
    //OnClick method for starting AllReports Activity
    public void allReports(View view) {
        Intent intent = new Intent(this,AllReports.class);
        startActivity(intent);
    }

}