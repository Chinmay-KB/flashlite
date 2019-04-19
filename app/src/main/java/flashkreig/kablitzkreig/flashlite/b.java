package flashkreig.kablitzkreig.flashlite;

import android.app.Service;
import android.content.Intent;
import android.hardware.camera2.CameraManager;
import android.os.IBinder;

public class b extends Service {
    private CameraManager f3d = null;
    private String[] f4e = null;
    private boolean f5f = false;

    void m2c() {
        try {
            this.f3d = (CameraManager) getApplicationContext().getSystemService(getApplicationContext().CAMERA_SERVICE);
            this.f4e = this.f3d.getCameraIdList();
            this.f3d.setTorchMode(this.f4e[0], true);
        } catch (Exception e) {
        }
    }
    void m3d() {
        if (this.f3d != null) {
            try {
                this.f3d.setTorchMode(this.f4e[0], false);
                this.f3d = null;
            } catch (Exception e) {
            }
        }
    }


    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onDestroy() {
        m3d();
    }
    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.f5f) {
            stopSelf();
        } else if (getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
            m2c();
            this.f5f = true;
        } else {
            stopSelf();
        }
        return Service.START_STICKY_COMPATIBILITY;
    }
}