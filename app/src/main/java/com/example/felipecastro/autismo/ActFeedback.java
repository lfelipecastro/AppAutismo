package com.example.felipecastro.autismo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActFeedback extends AppCompatActivity {
    @BindView(R.id.piechart) PieChart pieChart;
    @BindView(R.id.btnFadbak)Button btnFadbak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_feedback);
        ButterKnife.bind(this);
        pieChart.setUsePercentValues(true);

        ArrayList<Entry> valorF = new ArrayList<>();
        ArrayList<String> valorS = new ArrayList<>();
        int totQ=getIntent().getIntExtra("num_quest",20);
        int nQuestoes=getIntent().getIntExtra("num_sim",5);
        //verde cclari
        //vemelho ser
        valorF.add(new Entry(nQuestoes, 0));
        valorF.add(new Entry(totQ-nQuestoes, 1));
        valorS.add("Chances de ter Autismo");
        valorS.add("Chances de não ter Autismo");
        PieDataSet pieDataSet = new PieDataSet(valorF,"Legenda");
        PieData data = new PieData(valorS,pieDataSet);
        data.setValueFormatter(new PercentFormatter());
        pieChart.setData(data);
        int[] cores = {Color.parseColor("#DD2C00"),Color.parseColor("#FFA000")};
        pieDataSet.setColors(ColorTemplate.createColors(cores));
        pieChart.setDescription("Resultado do diagnostico de autismo "+pieDataSet.getYValForXIndex(0));
        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(0f);
        pieChart.setHoleRadius(100f);
        //Animação personalizada
        ObjectAnimator animator = ObjectAnimator.ofFloat(pieChart,"holeRadius",100f,0f);
        animator.setDuration(2000);
        animator.start();
        data.setValueTextSize(16f);
        data.setValueTextColor(Color.BLACK);
        pieChart.animateXY(1400, 1400);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pieChart.setDrawHoleEnabled(false);
            }
        }, 1419);

        btnFadbak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActFeedback.this,Principal.class);
                finish();
                startActivity(intent);
            }
        });
    }
    public void scaleView(View v, float startScale, float endScale) {
    }
}
