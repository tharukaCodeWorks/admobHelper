package com.edusoft.admobhelper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class WebAppInterface extends Activity{

    InterstitialAd mInterstitialAd;

    Context mContext;
    public WebAppInterface(Context mContext, InterstitialAd ad)
    {
        this.mContext = mContext;
        this.mInterstitialAd = ad;
    }

    // Show a toast from the web page
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void showIntertial()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showAd();
            }
        });
    }

    private void showAd()
    {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
        } else {
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
        }
    }


}
