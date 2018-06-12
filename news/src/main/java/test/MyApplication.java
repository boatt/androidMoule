package test;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;


public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
//        if (isAppDebug()) {
//            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
//            ARouter.openDebug();
//            ARouter.openLog();
//        }
//        ARouter.init(this);
    }

    public boolean isAppDebug() {
        if (TextUtils.isEmpty(getPackageName())) return false;
        try {
            PackageManager pm = getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(getPackageName(), 0);
            return ai != null && (ai.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
