package com.staytune;

import android.app.Application;
import android.util.Log;

import io.invertase.firebase.analytics.RNFirebaseAnalyticsPackage; // <-- Add this line

import com.facebook.react.PackageList;
import com.facebook.hermes.reactexecutor.HermesExecutorFactory;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.ReactApplication;
import com.wenkesj.voice.VoicePackage;
import de.innfactory.apiai.RNApiAiPackage;
import io.invertase.firebase.RNFirebasePackage;
import com.RNFetchBlob.RNFetchBlobPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.marianhello.bgloc.react.BackgroundGeolocationPackage;
import com.geektime.rnonesignalandroid.ReactNativeOneSignalPackage;
import com.horcrux.svg.SvgPackage;
import iyegoroff.RNTextGradient.RNTextGradientPackage;
import com.BV.LinearGradient.LinearGradientPackage;
import com.airbnb.android.react.maps.MapsPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      @SuppressWarnings("UnnecessaryLocalVariable")
      List<ReactPackage> packages = new PackageList(this).getPackages();
      //Packages that cannot be autolinked yet can be added manually here, for example:
      //packages.add(new MyReactNativePackage());
      packages.add(new RNFirebaseAnalyticsPackage()); // <-- Add this line
      //packages.add(new BackgroundGeolocationPackage()); // <---- Add the Package

      return packages;
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
  }
}
