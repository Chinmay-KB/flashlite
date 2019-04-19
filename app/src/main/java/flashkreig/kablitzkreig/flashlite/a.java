package flashkreig.kablitzkreig.flashlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class a extends Activity {
    protected void onCreate(Bundle m){super.onCreate(m);startService(new Intent(this, b.class));finish();}protected void onDestroy(){super.onDestroy(); }
}