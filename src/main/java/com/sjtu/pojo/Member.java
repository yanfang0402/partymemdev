package com.sjtu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String mId;
    private String mPassword;
    private int mLevel;
    private String mName;
    private String mClass;
    private String mGender;
    private String mNation;
    private String mNativePlace;
    private Date mAdmissionTime;
    private String mIdCard;
    private String mPhone;
    private String mPlace;
    private String mFamilyPlace;
    private String mPartyName;
    private String mAward;
    private Date sqsTime;
    private Date tjbTime;
    private Date jjfzTime;
    private String lxrNameOne;
    private String lxrNameTwo;
    private String kcbStateOne;
    private Date jjfzjyTime;
    private Date sxhbTimeOne;
    private Date sxhbTimeTwo;
    private Date sxhbTimeThree;
    private Date sxhbTimeFour;
    private Date fzdxTime;
    private String jsrNameOne;
    private String jsrNameTwo;
    private String fatherPolitics;
    private String motherPolitics;
    private Date fzdxjyTime;
    private Date zzTime;
    private Date fzgsTime;
    private String zysState;
    private Date ybdyTime;
    private Date dzztgTime;
    private String thrName;
    private Date sxhbTimeFive;
    private Date sxhbTimeSix;
    private Date sxhbTimeSeven;
    private Date sxhbTimeEight;
    private String kcbStateTwo;
    private Date zzsqTime;
    private Date zzgsTime;
    private Date zzTimeTheory;
    private Date zzTimeAct;

    public Member(String mId, String mPassword, int mLevel, String mName, String mClass, String mGender, String mNation, String mNativePlace, Date mAdmissionTime, String mIdCard, String mPhone, String mPlace, String mFamilyPlace) {
        this.mId = mId;
        this.mPassword = mPassword;
        this.mLevel = mLevel;
        this.mName = mName;
        this.mClass = mClass;
        this.mGender = mGender;
        this.mNation = mNation;
        this.mNativePlace = mNativePlace;
        this.mAdmissionTime = mAdmissionTime;
        this.mIdCard = mIdCard;
        this.mPhone = mPhone;
        this.mPlace = mPlace;
        this.mFamilyPlace = mFamilyPlace;
    }
}
