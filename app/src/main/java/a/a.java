package a;

import android.app.Activity;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;

public class a extends Activity {
    private static boolean on;

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        try {
            CameraManager c = (CameraManager) getSystemService(CAMERA_SERVICE);
            String id = c.getCameraIdList()[0];
            c.setTorchMode(id, !on);
            on = !on;
        } catch (Exception e) {
        }
        finish();
    }
}
