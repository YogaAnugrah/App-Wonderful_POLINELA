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

public class TektanActivity extends AppCompatActivity implements View.OnClickListener {
    CardView tektan1, tektan2, tektan3, tektan4, tektan5, tektan6, tektan7;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tektan);

        tektan1 = (CardView) findViewById(R.id.card3);
        tektan1.setOnClickListener(this);

        tektan2 = (CardView) findViewById(R.id.card4);
        tektan2.setOnClickListener(this);

        tektan3 = (CardView) findViewById(R.id.card5);
        tektan3.setOnClickListener(this);

        tektan4 = (CardView) findViewById(R.id.card7);
        tektan4.setOnClickListener(this);

        tektan5 = (CardView) findViewById(R.id.card8);
        tektan5.setOnClickListener(this);

        tektan6 = (CardView) findViewById(R.id.card9);
        tektan6.setOnClickListener(this);

        tektan7 = (CardView) findViewById(R.id.card10);
        tektan7.setOnClickListener(this);

        //        load database
        DatabaseHelper mDBHelper = new DatabaseHelper(this);
        if (mDBHelper.openDatabase())
            db = mDBHelper.getReadableDatabase();

//        ambil kode prodi yang dipilih dari menu sebelumnya, menu daftar prodi
//        String id_jurusan = getIntent().getStringExtra("id_jurusan");


//        ambil data prodi dari database
        String query_jurusan = "SELECT *  FROM jurusan WHERE id_jurusan=3";
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
            Intent moveIntent = new Intent( TektanActivity.this, d2_patiseri.class);
            startActivity(moveIntent);
        } else if (view.getId() == R.id.card4) {
            Intent moveIntent = new Intent(TektanActivity.this, d3_tsl.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card5) {
            Intent moveIntent = new Intent(TektanActivity.this, d3_mp.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card7) {
            Intent moveIntent = new Intent(TektanActivity.this, d3_tepa.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card8) {
            Intent moveIntent = new Intent(TektanActivity.this, d4_trki.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card9) {
            Intent moveIntent = new Intent(TektanActivity.this, d4_trkjj.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card10) {
            Intent moveIntent = new Intent(TektanActivity.this, d4_ppa.class);
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