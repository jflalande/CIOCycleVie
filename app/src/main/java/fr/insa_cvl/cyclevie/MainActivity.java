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
        Log.i("MOOC", "Create !");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BROWSER
        Button browser = (Button)findViewById(R.id.browser);
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(browserIntent);
            }
        });

        // Alert dialog
        Button dialog = (Button)findViewById(R.id.dialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
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

        Button askpermission = (Button)findViewById(R.id.askpermission);
        askpermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_CONTACTS}, 1);
            }
        });

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
    protected void onStart() { super.onStart(); Log.i("MOOC", "Start !"); }

    @Override
    protected void onResume() { super.onResume(); Log.i("MOOC", "Resume !"); }

    @Override
    protected void onPause() { super.onPause(); Log.i("MOOC", "Pause !"); }

    @Override
    protected void onStop() { super.onStop(); Log.i("MOOC", "Stop !"); }

    @Override
    protected void onDestroy() { super.onDestroy(); Log.i("MOOC", "Destroy !"); }




















}
