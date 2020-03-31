package com.rnextension;

import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Map;
import java.util.HashMap;

public class SampleBridge extends ReactContextBaseJavaModule {
    private static ReactApplicationContext reactContext;

    @Override
    public String getName() {
        return "BridgeExample";
    }

    SampleBridge(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @ReactMethod
    public void showToast(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put("long", Toast.LENGTH_LONG);
        constants.put("short", Toast.LENGTH_SHORT);
        return constants;
    }

    @ReactMethod
    public void callbackExample(int tag, Callback errorCallback, Callback successCallback) {
        if(tag == 0) {
            successCallback.invoke("Yeah success");
        } else {
            errorCallback.invoke(":( error");
        }
    }

    @ReactMethod
    public void promiseExample(int tag, Promise promise) {
        if(tag == 0) {
            promise.resolve("Yeah success");
        } else {
            promise.reject(":( error", new IndexOutOfBoundsException());
        }
    }
}