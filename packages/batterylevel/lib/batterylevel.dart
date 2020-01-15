import 'dart:async';

import 'package:flutter/services.dart';
import 'package:flutter/material.dart';

/**
 *
    flutter packages pub publish --dry-run
    验证无误后，我们就可以运行发布命令了：
    flutter packages pub publish
 */
class Batterylevel {
  static const MethodChannel _channel = const MethodChannel('hx.flutter.io/battery');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<String> get BatteryLevel async{
    String batteryLevel;
    try{
      final int result = await _channel.invokeMethod('getBarreryLevel');
      batteryLevel = 'Battery level at $result % .';
    }on PlatformException catch(e){
      batteryLevel = "Failed to get battery level:'${e.message}";
    }
    return batteryLevel;
  }

}
