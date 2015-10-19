package com.joaopaulo.cap3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class CadastroActivity2 extends AppCompatActivity {


    private int[] imagens = {R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_cadastro2);

        GridView grid = (GridView) findViewById(R.id.gridAvatar);
        grid.setOnItemClickListener(onGridViewItemClick());
        grid.setAdapter(new ImageAdaptor(this));

    }

    private AdapterView.OnItemClickListener onGridViewItemClick() {
        return new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int posicao, long id){
                Toast.makeText(CadastroActivity2.this, "Imagem selecionada: " + posicao, Toast.LENGTH_SHORT).show();
            }
        };
    }
}
