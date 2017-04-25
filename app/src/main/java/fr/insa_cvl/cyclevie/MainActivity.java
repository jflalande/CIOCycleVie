package fr.insa_cvl.cyclevie;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("CIO", "onCreate !");

        // BROWSER
        Button browser = (Button)findViewById(R.id.browser);
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(browserIntent);
            }
        });

        // Ask permission
        Button askpermission = (Button)findViewById(R.id.askpermission);
        askpermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_CONTACTS}, 1);
            }
        });

        // Alert dialog
        Button dialog = (Button)findViewById(R.id.dialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this entry?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        // Activity as dialog
        Button activity2 = (Button)findViewById(R.id.activityasdialog);
        activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ActivityAsDialog.class);
                startActivity(i);
            }
        });



    }

    @Override
    protected void onRestart() { super.onRestart(); Log.i("CIO", "onRestart !"); }

    @Override
    protected void onStart() { super.onStart(); Log.i("CIO", "onStart !"); }

    @Override
    protected void onResume() { super.onResume(); Log.i("CIO", "onResume !"); }

    @Override
    protected void onPause() { super.onPause(); Log.i("CIO", "onPause !"); }

    @Override
    protected void onStop() { super.onStop(); Log.i("CIO", "onStop !"); }

    @Override
    protected void onDestroy() { super.onDestroy(); Log.i("CIO", "onDestroy !"); }




















}
