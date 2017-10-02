package adneom.poc_camra_nougat_verison;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.net.URI;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int CAMERA_PIC_REQUEST = 25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        File file = new File(getCacheDir(),"AR");
        Uri uri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName(), file);
        Log.i("Adneom","uri is "+uri.getPath());
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("Adneom",resultCode+" - "+resultCode+" - "+(data== null));
    }
}
