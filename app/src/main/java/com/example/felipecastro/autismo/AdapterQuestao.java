package com.example.felipecastro.autismo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.os.IResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by Felipe Castro on 30/11/2017.
 */

public class AdapterQuestao extends ArrayAdapter<Questao> {
    ArrayList<Questao> questoes;
    Context context;
    boolean clicado;
    String marc = "";

    public AdapterQuestao(ArrayList<Questao> questoes, Context context) {
        super(context, R.layout.lista_questao, questoes);
        this.context = context;
        this.questoes = questoes;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView;


        if (position == questoes.size() - 1) {

            rowView = inflater.inflate(R.layout.lista_questao_butao, parent, false);
            Button btnGerar = (Button) rowView.findViewById(R.id.btnGerar);

            btnGerar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setClicado(true);
                    boolean ok = true;
                    int nao_marcada=0;
                    int num_sims=0;
                    for (Questao qu : questoes) {
                        if (qu.getSim() != null) {
                            if (!qu.getSim().isChecked() && !qu.getNao().isChecked()) {
                                ok = false;
                                qu.getNao().setError("Escolha alguma opção!");
                                nao_marcada++;
                            } else {
                                qu.getNao().setError(null);
                                if (qu.getResposta()==qu.getEsperado()) {
                                    num_sims++;
                                }
                            }
                        }
                    }
                    if (ok) {
                        irFeedback(num_sims);
                    }else
                        Toast.makeText(context, "Você esqueceu de responder "
                                + nao_marcada + ((nao_marcada==1)? " questão!" : " questões!"), Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            rowView = inflater.inflate(R.layout.lista_questao, parent, false);
        }

        TextView questao = (TextView) rowView.findViewById(R.id.textView);
        TextView pergunta = (TextView) rowView.findViewById(R.id.textView3);
        RadioButton sim = (RadioButton) rowView.findViewById(R.id.radioButton);
        RadioButton nao = (RadioButton) rowView.findViewById(R.id.radioButton2);
        final Questao q = questoes.get(position);
        sim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                q.setResposta(1);
            }
        });
        nao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                q.setResposta(-1);
            }
        });
        q.setSim(sim);
        q.setNao(nao);

        if (clicado && q.getResposta() == 0) {
            nao.setError("Escolha alguma opção!");
        } else {
            nao.setError(null);
            if (q.getResposta() == 1)
                sim.setChecked(true);
            if (q.getResposta() == -1)
                nao.setChecked(true);
        }
        ConstraintLayout layoutGlobal = (ConstraintLayout) rowView.findViewById(R.id.constraintLayoutG);
        questao.setText(q.getQuestao());
        pergunta.setText(q.getPergunta());
        return rowView;
    }
    public void irFeedback(int num_sims) {
        Intent irResultado = new Intent(context, ActFeedback.class);
        irResultado.putExtra("num_sim", num_sims);
        irResultado.putExtra("num_quest", questoes.size());
        context.startActivity(irResultado);
        ((Activity)context).finish();
    }
    public void setClicado(boolean clicado) {
        this.clicado = clicado;
    }

    public boolean isClicado() {
        return clicado;
    }
}
