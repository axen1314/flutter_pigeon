package org.axen.flutter.pigeon;

import android.content.Context;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class FlutterPigeonPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private MethodChannel channel;
    private FlutterPigeon pigeon;
    private Context context;

    @Override
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        pigeon = FlutterPigeon.getInstance();
        context = binding.getApplicationContext();
        channel = new MethodChannel(binding.getBinaryMessenger(), "org.axen.flutter/flutter_pigeon");
        channel.setMethodCallHandler(this);
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
        FlutterPigeonDelegate delegate = pigeon.getDelegate();
        if (delegate != null) {
            delegate.call(context, call.method, call.arguments, result);
        } else {
            result.notImplemented();
        }
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        channel.setMethodCallHandler(null);
    }
}
