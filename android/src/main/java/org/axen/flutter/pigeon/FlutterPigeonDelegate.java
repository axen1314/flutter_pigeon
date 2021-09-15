package org.axen.flutter.pigeon;

import android.content.Context;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public interface FlutterPigeonDelegate {
    void call(Context context, String method, Object arguments, MethodChannel.Result result);
}
