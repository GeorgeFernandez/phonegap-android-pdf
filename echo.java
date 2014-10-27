/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.George.iexpensive.activity;

import java.io.File;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 *
 * @author 01021501
 */
public class Echo extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("echo")) {
            String message = args.getString(0);
            openFile(message);
            return true;
        }
        return false;
    }
//Function for opening file

    private PluginResult openFile(String fileUrl) {
        Log.d("FileViewerPlugin", "View file" + fileUrl);
        Intent intent = new Intent();
        intent.setAction(android.content.Intent.ACTION_VIEW);
        File file = new File(fileUrl);
        String extension = fileUrl.substring(fileUrl.lastIndexOf(".") + 1);
        String type = "";
        if (extension.toLowerCase().equals("pdf")) {
            type = "application/pdf";
        } else if (extension.toLowerCase().equals("flv")) {
            type = "video/flv";
        } else if (extension.toLowerCase().equals("mp4")) {
            type = "video/mp4";
        } else if (extension.toLowerCase().equals("jpg")) {
            type = "image/jpg";
        }
        intent.setDataAndType(Uri.fromFile(file), type);
        cordova.getActivity().startActivity(intent);
        Log.d("FileViewerPlugin", "View complete in" + fileUrl);
        return new PluginResult(PluginResult.Status.OK, fileUrl);
    }
}
