import 'dart:async';

import 'package:flutter/services.dart';

class Batterylevel {
  static const MethodChannel _channel =
      const MethodChannel('batterylevel');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
}
