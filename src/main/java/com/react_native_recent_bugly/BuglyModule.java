package com.react_native_recent_bugly;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.tencent.bugly.beta.Beta;

/**
 * Created by chenwenyu on 17-4-5.
 */

public class BuglyModule extends ReactContextBaseJavaModule {


    public BuglyModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "BuglyModule";
    }

    @ReactMethod
    public void checkUpgrade() {
        Beta.checkUpgrade();
    }
}
