package com.zircon.app.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;

import com.zircon.app.ZirconApp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jikoobaruah on 09/03/16.
 */
public class KeyUtils {

    public static void getKeyHash(){
        try {
            PackageInfo info = ZirconApp.getAppContext().getPackageManager().getPackageInfo(
                    "com.zircon.app",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }


}
