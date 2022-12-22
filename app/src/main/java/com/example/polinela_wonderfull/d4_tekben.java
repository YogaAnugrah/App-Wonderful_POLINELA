package com.example.polinela_wonderfull;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class d4_tekben extends AppCompatActivity {
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d4_tekben);

        //        load database
        DatabaseHelper mDBHelper = new DatabaseHelper(this);
        if (mDBHelper.openDatabase())
            db = mDBHelper.getReadableDatabase();

//        ambil kode prodi yang dipilih dari menu sebelumnya, menu daftar prodi
//        String id_jurusan = getIntent().getStringExtra("id_jurusan");


//        ambil data prodi dari database
        String query_prodi = "SELECT *  FROM pangan WHERE id_prodi=4";
        Cursor cursor_prodi = db.rawQuery(query_prodi, null);
        cursor_prodi.moveToFirst();


//        tampilkan data prodi kedalam textview
        TextView tv_nm_visi = findViewById(R.id.visi1);
        TextView tv_nm_misi = findViewById(R.id.misi1);


        tv_nm_visi.setText(cursor_prodi.getString(2));
        tv_nm_misi.setText(cursor_prodi.getString(3));
        cursor_prodi.close();


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