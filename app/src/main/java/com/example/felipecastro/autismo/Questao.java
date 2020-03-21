package com.example.felipecastro.autismo;

import android.support.annotation.NonNull;
import android.widget.RadioButton;

/**
 * Created by Felipe Castro on 30/11/2017.
 */

public class Questao {
    String questao;
    int esperado;

    public int getEsperado() {
        return esperado;
    }

    public void setEsperado(int esperado) {
        this.esperado = esperado;
    }

    String pergunta;
    int resposta;
    RadioButton sim;
    RadioButton nao;

    public RadioButton getSim() {
        return sim;
    }

    public void setSim(@NonNull RadioButton sim) {
        this.sim = sim;
    }

    public RadioButton getNao() {
        return nao;
    }

    public void setNao(@NonNull RadioButton nao) {
        this.nao = nao;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }

    public Questao(String questao, String pergunta,int esperado) {
        this.questao = questao;
        this.pergunta = pergunta;
        this.esperado = esperado;
    }
}
