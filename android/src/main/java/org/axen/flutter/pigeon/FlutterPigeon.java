package org.axen.flutter.pigeon;

import org.axen.flutter.pigeon.FlutterPigeonDelegate;

import java.util.HashMap;
import java.util.Map;

public class FlutterPigeon {
    private FlutterPigeonDelegate delegate;

    public static FlutterPigeon getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final FlutterPigeon INSTANCE = new FlutterPigeon();
    }

    public void setup(FlutterPigeonDelegate delegate) {
        this.delegate = delegate;
    }

    public FlutterPigeonDelegate getDelegate() {
        return delegate;
    }
}
