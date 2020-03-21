package com.example.felipecastro.autismo;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class Principal extends AppCompatActivity {
    Button iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        iniciar = (Button) findViewById(R.id.button);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**/
                Intent irParaQuiz = new Intent(Principal.this, Quiz.class);
                startActivity(irParaQuiz);
                /*/Intent irParaQuiz = new Intent(Principal.this, ActFeedback.class);
                startActivity(irParaQuiz);
                /**/
            }
        });
    }

    boolean clique = false;
    @Override
    public void onBackPressed() {
        if (clique == false) {
            Toast.makeText(Principal.this, "Aperte novamente para sair!", Toast.LENGTH_SHORT).show();
        } else {
            finish();
        }
        clique = true;
    }
}
