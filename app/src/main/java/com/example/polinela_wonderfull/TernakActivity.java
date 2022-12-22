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

public class TernakActivity extends AppCompatActivity implements View.OnClickListener {
    CardView ternak1, ternak2, ternak3, ternak4, ternak5;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ternak);

        ternak1 = (CardView) findViewById(R.id.card3);
        ternak1.setOnClickListener(this);

        ternak2 = (CardView) findViewById(R.id.card4);
        ternak2.setOnClickListener(this);

        ternak3 = (CardView) findViewById(R.id.card5);
        ternak3.setOnClickListener(this);

        ternak4 = (CardView) findViewById(R.id.card7);
        ternak4.setOnClickListener(this);

        ternak5 = (CardView) findViewById(R.id.card8);
        ternak5.setOnClickListener(this);

        //        load database
        DatabaseHelper mDBHelper = new DatabaseHelper(this);
        if (mDBHelper.openDatabase())
            db = mDBHelper.getReadableDatabase();

//        ambil kode prodi yang dipilih dari menu sebelumnya, menu daftar prodi
//        String id_jurusan = getIntent().getStringExtra("id_jurusan");


//        ambil data prodi dari database
        String query_jurusan = "SELECT *  FROM jurusan WHERE id_jurusan=4";
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
            Intent moveIntent = new Intent( TernakActivity.this, d3_proter.class);
            startActivity(moveIntent);
        } else if (view.getId() == R.id.card4) {
            Intent moveIntent = new Intent(TernakActivity.this, d3_bdp.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card5) {
            Intent moveIntent = new Intent(TernakActivity.this, d3_pt.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card7) {
            Intent moveIntent = new Intent(TernakActivity.this, d4_tekproter.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.card8) {
            Intent moveIntent = new Intent(TernakActivity.this, d4_tpi.class);
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