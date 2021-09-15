
import 'dart:async';

import 'package:flutter/services.dart';

class FlutterPigeon {
  static const MethodChannel _channel =
      const MethodChannel('org.axen.flutter/flutter_pigeon');

  static Future<T?> invoke<T>(String method, [ dynamic arguments ]) {
    return _channel.invokeMethod(method, arguments);
  }
}
