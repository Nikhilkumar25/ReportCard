package com.wordpress.smartedudotin.www.reportcard;

import androidx.annotation.NonNull;

public class ReportCard {

    private String mName;
    private String mPhysics;
    private String mMath;
    private String mChemistry;
    private int mIndex;


    @NonNull
    @Override
    public String toString() {
        return super.toString ();
    }

    public ReportCard(String mName, String mPhysics, String mMath, String mChemistry,int mIndex) {
        this.mName = mName;
        this.mPhysics = mPhysics;
        this.mMath = mMath;
        this.mChemistry = mChemistry;
        this.mIndex = mIndex;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhysics() {
        return mPhysics;
    }

    public void setmPhysics(String mPhysics) {
        this.mPhysics = mPhysics;
    }

    public String getmMath() {
        return mMath;
    }

    public void setmMath(String mMath) {
        this.mMath = mMath;
    }

    public String getmChemistry() {
        return mChemistry;
    }

    public void setmChemistry(String mChemistry) {
        this.mChemistry = mChemistry;
    }

    public int getmIndex() {
        return mIndex;
    }


}
