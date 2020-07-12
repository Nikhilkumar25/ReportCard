package com.wordpress.smartedudotin.www.reportcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ReportCardAdapter extends ArrayAdapter<ReportCard> {
    public ReportCardAdapter(@NonNull Context context, ArrayList<ReportCard> Object) {
        super (context, 0,Object);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listReportCards = convertView;
        if (listReportCards==null){
            listReportCards = LayoutInflater.from (getContext ()).inflate (R.layout.report_card_view,parent,false);
        }

        final ReportCard currentReportCard = getItem (position);

        TextView name = (TextView) listReportCards.findViewById (R.id.studentNameView);
        assert currentReportCard != null;
        name.setText (currentReportCard.getmName ());

        TextView physics = (TextView) listReportCards.findViewById (R.id.physicsMarksView);
        physics.setText (currentReportCard.getmPhysics ());

        TextView maths = (TextView) listReportCards.findViewById (R.id.mathMarksView);
        maths.setText (currentReportCard.getmMath ());

        TextView chem = (TextView) listReportCards.findViewById (R.id.chemistryMarksView);
        chem.setText (currentReportCard.getmChemistry ());

        ImageView deleteSingleBtn = (ImageView) listReportCards.findViewById (R.id.delete_single_btn);
        //
        deleteSingleBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (getContext (),"Deleted",Toast.LENGTH_SHORT).show ();

                MainActivity.repository.studentReportCards.remove (currentReportCard.getmIndex ());

                Toast.makeText (getContext (),""+MainActivity.repository.studentReportCards.size (),Toast.LENGTH_SHORT).show ();

                MainActivity.repository.SavingPrefs ();
            }
        });

        return listReportCards;
    }
}