package com.wordpress.smartedudotin.www.reportcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.wordpress.smartedudotin.www.reportcard.MainActivity.repository;

public class AllReports extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_all_reports);

        //to execute GridView
        GridViewAdapter ();

    }

    private void GridViewAdapter(){

        //to get the data stored in Prefs
        repository.GetPrefs ();

        ReportCardAdapter reportCardAdapter = new ReportCardAdapter (this , MainActivity.repository.studentReportCards);

        GridView gridView = (GridView) findViewById (R.id.grid_report);

        gridView.setAdapter (reportCardAdapter);

    }


    public void DeleteAll(View view) {
        //Calling this method to clear data saved in SharedPreferences
        repository.ClearPrefs ();

        //Calling this method to clear all ArrayList data
        repository.studentReportCards.clear ();

        Toast.makeText (this,"Cleared",Toast.LENGTH_SHORT).show ();

        //to again create a SharedPref
        repository.SavingPrefs ();

        //to refresh GridView
        GridViewAdapter ();

    }

    public void reFresh(View view) {
        GridViewAdapter ();
    }
}