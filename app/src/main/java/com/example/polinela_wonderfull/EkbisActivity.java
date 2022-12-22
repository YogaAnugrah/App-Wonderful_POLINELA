package com.example.polinela_wonderfull;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class EkbisActivity extends AppCompatActivity implements View.OnClickListener {
    CardView ekbis1, ekbis2, ekbis3, ekbis4, ekbis5, ekbis6, ekbis7, ekbis8, ekbis9;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekbis);

        ekbis1 = (CardView) findViewById(R.id.card3);
        ekbis1.setOnClickListener(this);

        ekbis2 = (CardView) findViewById(R.id.card4);
        ekbis2.setOnClickListener(this);

        ekbis3 = (CardView) findViewById(R.id.card5);
        ekbis3.setOnClickListener(this);

        ekbis4 = (CardView) findViewById(R.id.card7);
        ekbis4.setOnClickListener(this);

        ekbis5 = (CardView) findViewById(R.id.card8);
        ekbis5.setOnClickListener(this);

        ekbis6 = (CardView) findViewById(R.id.card9);
        ekbis6.setOnClickListener(this);

        ekbis7 = (CardView) findViewById(R.id.card10);
        ekbis7.setOnClickListener(this);

        ekbis8 = (CardView) findViewById(R.id.card11);
        ekbis8.setOnClickListener(this);

        ekbis9 = (CardView) findViewById(R.id.card12);
        ekbis9.setOnClickListener(this);

        //        load database
        DatabaseHelper mDBHelper = new DatabaseHelper(this);
        if (mDBHelper.openDatabase())
            db = mDBHelper.getReadableDatabase();

//        ambil kode prodi yang dipilih dari menu sebelumnya, menu daftar prodi
//        String id_jurusan = getIntent().getStringExtra("id_jurusan");


//        ambil data prodi dari database
        String query_jurusan = "SELECT *  FROM jurusan WHERE id_jurusan=5";
        Cursor cursor_jurusan = db.rawQuery(query_jurusan, null);
        cursor_jurusan.moveToFirst();


//        tampilkan data prodi kedalam textview
        TextView tv_nm_visi = findViewById(R.id.tv_vsi1);
        TextView tv_nm_misi = findViewById(R.id.tv_vsi2);


        tv_nm_visi.setText(cursor_jurusan.getString(2));
        tv_nm_misi.setText(cursor_jurusan.getString(3));
        cursor_jurusan.close();


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.card3) {
            Intent moveIntent = new Intent( EkbisActivity.this, d2_admp.class);
            startActivity(moveIntent);
        } else if (view.getId() == R.id.card4) {
            Intent moveIntent = new Intent(EkbisActivity.this, d3_mi.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card5) {
            Intent moveIntent = new Intent(EkbisActivity.this, d3_pw.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card7) {
            Intent moveIntent = new Intent(EkbisActivity.this, d4_agri.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card8) {
            Intent moveIntent = new Intent(EkbisActivity.this, d4_agribisnis.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card9) {
            Intent moveIntent = new Intent(EkbisActivity.this, d4_akp.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card10) {
            Intent moveIntent = new Intent(EkbisActivity.this, d4_akbd.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card11) {
            Intent moveIntent = new Intent(EkbisActivity.this, d4_hotel.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card12) {
            Intent moveIntent = new Intent(EkbisActivity.this, d4_internet.class);
            startActivity(moveIntent);
        }
    }
    //    biar tombol back di toolbar dan tombol back di device tidak me restart menu sebelumnya/menu activity
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            onBackPressed();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}