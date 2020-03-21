package com.example.felipecastro.autismo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class Quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ListView lista = (ListView) findViewById(R.id.listView);
        final ArrayList<Questao> questoes = adicionarQuestoes();
        final AdapterQuestao adapter = new AdapterQuestao(questoes, this);
        lista.setAdapter(adapter);
    }

    boolean clique = false;
    @Override
    public void onBackPressed() {
        if (clique == false) {
            Toast.makeText(Quiz.this, "Aperte novamente para voltar!", Toast.LENGTH_SHORT).show();
        } else {
            finish();
        }
        clique = true;
    }

    private ArrayList<Questao> adicionarQuestoes() {
        ArrayList<Questao> questoes = new ArrayList<Questao>();
        Questao e = new Questao("1ª Questão",
                "Seu filho tem interesse em fazer amizade com outras crianças?",-1);
        questoes.add(e);

        e = new Questao("2ª Questão",
                "Seu filho gosta de subir em coisas como escadas ou móveis?",-1);
        questoes.add(e);

        e = new Questao("3ª Questão",
                "Seu filho gosta de se esconder, de mostrar o rosto ou de esconde-esconde?",-1);
        questoes.add(e);

        e = new Questao("4ª Questão",
                "Seu filho já brincou de faz de conta, como por exemplo fazer de conta que " +
                        "está falando no telefone ou cuidando da boneca?",-1);
        questoes.add(e);

        e = new Questao("5ª Questão",
                "Seu filho já usou o dedo indicador dele para apontar para alguma coisa?",-1);
        questoes.add(e);

        e = new Questao("6ª Questão",
                "Seu filho consegue brincar de forma correta com brinquedos pequenos " +
                        "remexendo ou derrubando-o, exemplo brinquedos, carros, blocos ou legos, " +
                        "sem apenas colocar na boca?",-1);
        questoes.add(e);

        e = new Questao("7ª Questão",
                "Seu filho alguma vez trouxe objetos para você (Pais) para lhe mostrar " +
                        "este objeto?",-1);
        questoes.add(e);

        e = new Questao("8ª Questão",
                "Seu filho olha pra você no olho por mais de um segundo ou dois?",-1);
        questoes.add(e);

        e = new Questao("9ª Questão",
                "O seu filho já apareceu muito sensível a barulhos, exemplo, (ex.: " +
                        "tapando os ouvidos)?",1);
        questoes.add(e);

        e = new Questao("10ª Questão",
                "O seu filho sorri em resposta ao seu rosto ou ao seu sorriso?",-1);
        questoes.add(e);

        e = new Questao("11ª Questão",
                "O seu filho imita você (ex.: você faz expressões/caretas e seu\n" +
                        " filho imita)?",-1);
        questoes.add(e);

        e = new Questao("12ª Questão",
                "O seu filho responde quando você o chama pelo nome?",-1);
        questoes.add(e);

        e = new Questao("13ª Questão",
                "Se você aponta um brinquedo do outro lado do cômodo, o\n" +
                        "seu filho olha para ele?",-1);
        questoes.add(e);

        e = new Questao("14ª Questão",
                "O seu filho olha para coisas que você está olhando?",-1);
        questoes.add(e);

        e = new Questao("15ª Questão",
                "O seu filho faz movimentos estranhos com os dedos perto\n" +
                        "do rosto dele?",1);
        questoes.add(e);

        e = new Questao("16ª Questão",
                "O seu filho olha para o seu rosto para conferir a sua reação" +
                        " quando vê algo estranho?",-1);
        questoes.add(e);

        e = new Questao("17ª Questão",
                "O seu filho tenta atrair a sua atenção para a atividade dele?",-1);
        questoes.add(e);

        e = new Questao("18ª Questão",
                "Você alguma vez já se perguntou se seu filho é surdo?",1);
        questoes.add(e);

        e = new Questao("19ª Questão",
                "O seu filho entende o que as pessoas dizem?",-1);
        questoes.add(e);

        e = new Questao("20ª Questão",
                "O seu filho às vezes fica aéreo, “olhando para o nada” ou\n" +
                        "caminhando sem direção definida?",1);
        questoes.add(e);

        return questoes;
    }
}
