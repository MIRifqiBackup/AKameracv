package com.aqua.akameracv;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "RekamDataWajah";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (OpenCVLoader.initDebug()) {
            // OpenCV terinstal dengan sukses
            Log.i(TAG, "OpenCV terinstal dengan sukses");
        } else {
            // OpenCV tidak terinstal
            Log.e(TAG, "OpenCV tidak terinstal");
        }


        Button buttonPresensi = findViewById(R.id.buttonPresensi);
        Button buttonDaftarHadir = findViewById(R.id.buttonDaftarHadir);
        Button buttonDaftarMurid = findViewById(R.id.buttonDaftarMurid);
        Button buttonDataMurid = findViewById(R.id.buttonDataMurid);

        // Tambahkan logika untuk tombol di sini, seperti mengatur onClickListener
        // Misalnya:
        buttonPresensi.setOnClickListener(v -> {
            // Aksi yang ingin dijalankan ketika tombol "Presensi" diklik
            showPresensiDialog();
        });

        // Tambahkan logika untuk tombol lainnya sesuai kebutuhan Anda
    }
    private void showPresensiDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Presensi");
        builder.setMessage("Pilih aksi:");
        builder.setPositiveButton("Cek Kehadiran", (dialog, which) -> {
            // Aksi yang ingin dijalankan ketika tombol "Cek Kehadiran" diklik
        });
        builder.setNegativeButton("Rekam Data Wajah", (dialog, which) -> {
            // Aksi yang ingin dijalankan ketika tombol "Rekam Data Wajah" diklik
            Intent intent = new Intent(MainActivity.this, RekamDataWajah.class);
            startActivity(intent);
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}