package com.joaopaulo.cap3.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.joaopaulo.cap3.R;
import com.joaopaulo.cap3.domain.Usuario;

public class CadastroActivity2 extends AppCompatActivity{

    String userLogin, userSenha, userEmail;
    int avatarImgCode;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.activity_cadastro2);

        Bundle args = getIntent().getExtras();
        userLogin = args.getString("userLogin");
        userSenha = args.getString("userSenha");
        userEmail = args.getString("userEmail");

        Button btConfirmarCadastro = (Button) findViewById(R.id.btConfirmaCadastro);

        GridView grid = (GridView) findViewById(R.id.gridAvatar);
        grid.setOnItemClickListener(onGridViewItemClick());
        grid.setAdapter(new ImageAdaptor(this));

        //Teste
//        Toast.makeText(this, userLogin, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, userSenha, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, userEmail, Toast.LENGTH_SHORT).show();
        //fim teste


        btConfirmarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btConfirmaCadastro) {
                    Usuario usuario = new Usuario(userLogin, userSenha, userEmail, avatarImgCode);
                    /**
                     * TODO: inserir usuario no arquivo json de cadastro
                     */

                    Toast.makeText(CadastroActivity2.this, "teste", Toast.LENGTH_SHORT).show();

                    AlertDialog.Builder builder = new AlertDialog.Builder(CadastroActivity2.this);
                    builder.setTitle("Tudo Certo!");
                    builder.setMessage("Você foi cadastrado com sucesso!");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(CadastroActivity2.this, HomeActivity.class);
                            Bundle params = new Bundle();
                            params.putString("login", userLogin);
                            intent.putExtras(params);
                            startActivity(intent);
                            return;
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }

    private AdapterView.OnItemClickListener onGridViewItemClick() {
        return new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int posicao, long id) {
                Toast.makeText(CadastroActivity2.this, "Imagem selecionada: " + posicao, Toast.LENGTH_SHORT).show();
                avatarImgCode = posicao;
                ImageView imgSelecionada = (ImageView) findViewById(R.id.img);
                /**
                 * TODO: implementar efeito de seleção do avatar
                 */

            }
        };
    }

}
