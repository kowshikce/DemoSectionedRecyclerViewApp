package com.example.sectionedrecyclerview.DataLoader;

import android.content.Context;

import com.example.sectionedrecyclerview.R;

public class HomePreodicReset {
    public static int count = 0;

    public static void resetIf(int num) {
        if (num >= 5) {
            count = 0;
        }
    }

    public static int getImageid(Context context) {
        switch (count) {
            case 0:
                resetIf(count);
                count++;
                return R.drawable.hediedwith;
            case 1:
                resetIf(count);
                count++;
                return R.drawable.mariasemples;
            case 2:
                resetIf(count);
                count++;
                return R.drawable.privacy;
            case 3:
                resetIf(count);
                count++;
                return R.drawable.themartian;
            case 4:
                resetIf(count);
                count++;
                return R.drawable.thevigitarian;
            case 5:
                resetIf(count);
                count++;
                return R.drawable.thewildrobot;
            default:
                resetIf(count);
                return R.drawable.thewildrobot;
        }

    }



}
