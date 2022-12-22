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

public class KebunActivity extends AppCompatActivity implements View.OnClickListener {
    CardView kebun1, kebun2, kebun3;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kebun);

        kebun1 = (CardView) findViewById(R.id.card3);
        kebun1.setOnClickListener(this);

        kebun2 = (CardView) findViewById(R.id.card4);
        kebun2.setOnClickListener(this);

        kebun3 = (CardView) findViewById(R.id.card5);
        kebun3.setOnClickListener(this);

        //        load database
        DatabaseHelper mDBHelper = new DatabaseHelper(this);
        if (mDBHelper.openDatabase())
            db = mDBHelper.getReadableDatabase();

//        ambil kode prodi yang dipilih dari menu sebelumnya, menu daftar prodi
//        String id_jurusan = getIntent().getStringExtra("id_jurusan");


//        ambil data prodi dari database
        String query_jurusan = "SELECT *  FROM jurusan WHERE id_jurusan=2";
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
            Intent moveIntent = new Intent( KebunActivity.this, d3_ptpbun.class);
            startActivity(moveIntent);
        } else if (view.getId() == R.id.card4) {
            Intent moveIntent = new Intent(KebunActivity.this, d4_pmip.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card5) {
            Intent moveIntent = new Intent(KebunActivity.this, d4_kopi.class);
            startActivity(moveIntent);
        }}
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