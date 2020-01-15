package com.hxflutter.batterylevel;


import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

import static android.content.Context.BATTERY_SERVICE;

/** BatterylevelPlugin */
public class BatterylevelPlugin implements MethodCallHandler {
  private static Registrar context;
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    context = registrar;
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "batterylevel");
    channel.setMethodCallHandler(new BatterylevelPlugin());
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    }
    if(call.method.equals("getBarreryLevel")){
      result.success(getBatteryLevel());
    }
    else {
      result.notImplemented();
    }
  }

  //获取手机剩余电量
  private double getBatteryLevel(){
    double battery = -1;
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
      BatteryManager manager = (BatteryManager) context.activeContext().getSystemService(BATTERY_SERVICE);
      battery = manager.getLongProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
    }else{
      Intent intent = new ContextWrapper(context.activeContext().getApplicationContext()).registerReceiver(null,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
      battery = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1) / intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);
    }
    return battery;
  }

}
