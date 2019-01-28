package com.arcore.first.arfirst;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Environment;

import com.google.ar.sceneform.ux.ArFragment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class WritingArFragment extends ArFragment {
    @Override
    public String[] getAdditionalPermissions() {

    String[] additionalPermissions = super.getAdditionalPermissions();
    int  permissionLength =  additionalPermissions != null ? additionalPermissions.length : 0 ;
    String[] permissions = new String[permissionLength +1];
    permissions[0] = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    if(permissionLength>0){
        System.arraycopy(additionalPermissions,0,permissions,1,additionalPermissions.length);
        }
        return permissions;
    }

}
