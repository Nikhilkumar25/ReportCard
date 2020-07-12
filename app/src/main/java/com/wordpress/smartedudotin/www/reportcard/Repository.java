package com.wordpress.smartedudotin.www.reportcard;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static com.wordpress.smartedudotin.www.reportcard.MainActivity.repository;

public class Repository {



    ArrayList<ReportCard> studentReportCards = new ArrayList<ReportCard> ();

    public Context context;

    //getting context
    public void setContext(Context context){
        this.context = context;
    }


    //getting previously saved preferences
    public void GetPrefs(){ //Reading ArrayList from Shared Prefs
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPrefs.getString("reportCard", "");

        Log.i ("AllReports34",""+json);
        Type type = new TypeToken<ArrayList<ReportCard>> () {}.getType();

        Log.i ("AllReports37",""+type);
        studentReportCards  = gson.fromJson(json, type);}


        //Saving new array
    public void SaveReportCard(String name,String phyMarks,String mathMarks, String chemMarks){

        SavingPrefs ();
        GetPrefs ();

        Log.i ("Repository","Save Report Card");


        Toast.makeText (context,""+studentReportCards.size (),Toast.LENGTH_SHORT).show ();

        studentReportCards.add (new ReportCard (name,phyMarks,mathMarks,chemMarks,studentReportCards.size ()));

        SavingPrefs ();
    }

    public void SavingPrefs(){
        //Saving ArrayList in Shared Prefs
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(studentReportCards);

        editor.putString("reportCard", json);
        editor.apply();
    }

    public void ClearPrefs(){
        //in this method the data and the key of SharedPref get cleared
        //data in ArrayList remains the same
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.clear ();
        editor.apply ();
    }

}
