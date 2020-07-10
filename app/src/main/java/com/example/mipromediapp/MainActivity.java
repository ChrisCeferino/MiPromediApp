package com.example.mipromediapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    SeekBar suckbar;
    TextView cantNotas,promFin,ponFin;
    EditText not1,not2,not3,not4,not5,not6,not7,not8,not9,not10,
            pond1,pond2,pond3,pond4,pond5,pond6,pond7,pond8,pond9,pond10;
    TableRow row1,row2,row3,row4,row5,row6,row7,row8,row9,row10;
    ImageButton bor2,bor3,bor4,bor5,bor6,bor7,bor8,bor9,bor10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        promFin = (TextView) findViewById(R.id.PromedioFinalTxtV);
        ponFin = (TextView) findViewById(R.id.pondFina);
//
        bor2 = (ImageButton) findViewById(R.id.borrar2);
        bor3 = (ImageButton) findViewById(R.id.borrar3);
        bor4 = (ImageButton) findViewById(R.id.borrar4);
        bor5 = (ImageButton) findViewById(R.id.borrar5);
        bor6 = (ImageButton) findViewById(R.id.borrar6);
        bor7 = (ImageButton) findViewById(R.id.borrar7);
        bor8 = (ImageButton) findViewById(R.id.borrar8);
        bor9 = (ImageButton) findViewById(R.id.borrar9);
        bor10 = (ImageButton) findViewById(R.id.borrar10);
//
        suckbar = (SeekBar) findViewById(R.id.sickbar);
        cantNotas = (TextView) findViewById(R.id.cantiNotas);
        row1 = (TableRow) findViewById(R.id.Nota1tablR);
        row2 = (TableRow) findViewById(R.id.Nota2tablR);
        row3 = (TableRow) findViewById(R.id.Nota3tablR);
        row4 = (TableRow) findViewById(R.id.nota4tablR);
        row5 = (TableRow) findViewById(R.id.nota5tablR);
        row6 = (TableRow) findViewById(R.id.nota6tablR);
        row7 = (TableRow) findViewById(R.id.nota7tablR);
        row8 = (TableRow) findViewById(R.id.nota8tablR);
        row9 = (TableRow) findViewById(R.id.nota9tablR);
        row10 = (TableRow) findViewById(R.id.nota10tablR);
        final TableRow lista[] = {row1, row2, row3, row4, row5, row6, row7, row8, row9, row10};
//
        not1 = (EditText) findViewById(R.id.notaET1);
        not2 = (EditText) findViewById(R.id.notaET2);
        not3 = (EditText) findViewById(R.id.notaET3);
        not4 = (EditText) findViewById(R.id.notaET4);
        not5 = (EditText) findViewById(R.id.notaET5);
        not6 = (EditText) findViewById(R.id.notaET6);
        not7 = (EditText) findViewById(R.id.notaET7);
        not8= (EditText) findViewById(R.id.notaET8);
        not9 = (EditText) findViewById(R.id.notaET9);
        not10 = (EditText) findViewById(R.id.notaET10);
        final EditText listNot[] = {not1,not2,not3,not4,not5,not6,not7,not8,not9,not10};
//
        pond1 = (EditText) findViewById(R.id.ponderaET1);
        pond2 = (EditText) findViewById(R.id.ponderaET2);
        pond3 = (EditText) findViewById(R.id.ponderaET3);
        pond4 = (EditText) findViewById(R.id.ponderaET4);
        pond5 = (EditText) findViewById(R.id.ponderaET5);
        pond6 = (EditText) findViewById(R.id.ponderaET6);
        pond7 = (EditText) findViewById(R.id.ponderaET7);
        pond8 = (EditText) findViewById(R.id.ponderaET8);
        pond9 = (EditText) findViewById(R.id.ponderaET9);
        pond10 = (EditText) findViewById(R.id.ponderaET10);
        final EditText listPond[] = {pond1,pond2,pond3,pond4,pond5,pond6,pond7,pond8,pond9,pond10};
//
        row1.setVisibility(View.VISIBLE);
        row2.setVisibility(View.VISIBLE);
        row3.setVisibility(View.INVISIBLE);
        row4.setVisibility(View.INVISIBLE);
        row5.setVisibility(View.INVISIBLE);
        row6.setVisibility(View.INVISIBLE);
        row7.setVisibility(View.INVISIBLE);
        row8.setVisibility(View.INVISIBLE);
        row9.setVisibility(View.INVISIBLE);
        row10.setVisibility(View.INVISIBLE);
        cantNotas.setText(2 + "");
        suckbar.setProgress(1);
//
        suckbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cantNotas.setText(i + 1 + "");
                todoInvisible();
                for (int x = 0; x <= i; x++) {
                    lista[x].setVisibility(View.VISIBLE);
                }
                for (int x = 9; x > i; x--) {
                    lista[x].setVisibility(View.INVISIBLE);
                    listNot[x].setText("");
                    listPond[x].setText("");
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        //Cuando hace click al tacho de basura
        bor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ordenarNotas(2,lista,listNot,listPond);
                MovSeekBar(suckbar);
                promediar(lista,listNot,listPond);
            }
        });
        bor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ordenarNotas(3,lista,listNot,listPond);
                MovSeekBar(suckbar);
            }
        });
        bor4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ordenarNotas(4,lista,listNot,listPond);
                MovSeekBar(suckbar);
            }
        });
        bor5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ordenarNotas(5,lista,listNot,listPond);
                MovSeekBar(suckbar);
            }
        });
        bor6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ordenarNotas(6,lista,listNot,listPond);
                MovSeekBar(suckbar);
            }
        });
        bor7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ordenarNotas(7,lista,listNot,listPond);
                MovSeekBar(suckbar);
            }
        });
        bor8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ordenarNotas(8,lista,listNot,listPond);
                MovSeekBar(suckbar);
            }
        });
        bor9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ordenarNotas(9,lista,listNot,listPond);
                MovSeekBar(suckbar);
            }
        });
        bor10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ordenarNotas(10,lista,listNot,listPond);
                MovSeekBar(suckbar);
            }
        });
        not1.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarNota(0,listNot)){
                    if(revisarPonde(0,listPond)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        not2.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarNota(1,listNot)){
                    if(revisarPonde(1,listPond)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        not3.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarNota(2,listNot)){
                    if(revisarPonde(2,listPond)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        not4.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarNota(3,listNot)){
                    if(revisarPonde(3,listPond)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        not5.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarNota(4,listNot)){
                    if(revisarPonde(4,listPond)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        not6.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarNota(5,listNot)){
                    if(revisarPonde(5,listPond)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        not7.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarNota(6,listNot)){
                    if(revisarPonde(6,listPond)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        not8.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarNota(7,listNot)){
                    if(revisarPonde(7,listPond)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        not9.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarNota(8,listNot)){
                    if(revisarPonde(8,listPond)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        not10.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarNota(9,listNot)){
                    if(revisarPonde(9,listPond)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        pond1.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarPonde(0,listPond)){
                    if(revisarNota(0,listNot)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        pond2.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarPonde(1,listPond)){
                    if(revisarNota(1,listNot)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        pond3.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarPonde(2,listPond)){
                    if(revisarNota(2,listNot)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        pond4.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarPonde(3,listPond)){
                    if(revisarNota(3,listNot)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        pond5.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarPonde(4,listPond)){
                    if(revisarNota(4,listNot)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        pond6.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarPonde(5,listPond)){
                    if(revisarNota(5,listNot)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        pond7.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarPonde(6,listPond)){
                    if(revisarNota(6,listNot)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        pond8.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarPonde(7,listPond)){
                    if(revisarNota(7,listNot)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        pond9.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarPonde(8,listPond)){
                    if(revisarNota(8,listNot)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });
        pond10.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if(revisarPonde(9,listPond)){
                    if(revisarNota(9,listNot)){
                        promediar(lista,listNot,listPond);
                    }
                }
            }
        });


    }
    ///Metodos
    //hacer todos los campos invisibles
    public String todoInvisible(){
        row1.setVisibility(View.INVISIBLE);
        row2.setVisibility(View.INVISIBLE);
        row3.setVisibility(View.INVISIBLE);
        row4.setVisibility(View.INVISIBLE);
        row5.setVisibility(View.INVISIBLE);
        row6.setVisibility(View.INVISIBLE);
        row7.setVisibility(View.INVISIBLE);
        row8.setVisibility(View.INVISIBLE);
        row9.setVisibility(View.INVISIBLE);
        row10.setVisibility(View.INVISIBLE);
        return "";
    }
    //Ordenar Notas y borrar;
    public void ordenarNotas(int posiciobborrar,TableRow list[],EditText lnota[],EditText lpond[]){
        int cont=0,posc;
        posc=posiciobborrar-1;
        for(int l=0;l<=9;l++){
            if(list[l].getVisibility()== View.VISIBLE){
                cont++;
            }
        }
        lnota[posc].setText("");
        lpond[posc].setText("");
        for(int k=0;k <= (cont-1);k++){
                if(k >= posc){
                    if(k==9){
                        lnota[9].setText("");
                        lpond[9].setText("");
                    }else{
                        if(k==cont-1){
                            lnota[k].setText("");
                            lpond[k].setText("");
                            list[k].setVisibility(View.INVISIBLE);
                        }else{
                            lnota[k].setText(lnota[k+1].getText()+"");
                            lpond[k].setText(lpond[k+1].getText()+"");
                        }
                    }
                }
            }
    }
    //MoverProgressBar
    public void MovSeekBar(SeekBar s){
        int a =s.getProgress();
        int prog= a -1;
        s.setProgress(prog);
    }

    public Boolean revisarPonde(int posc,EditText lisPon[]){
        Boolean a=false;
        if(lisPon[posc].length()!= 0){
            if(Integer.parseInt(lisPon[posc].getText().toString())>= 1 && Integer.parseInt(lisPon[posc].getText().toString())<=100){
                a=true;
            }else{
                Toast.makeText(this,"El ponderado debe ser entre 1-100%",Toast.LENGTH_SHORT ).show();
            }
        }
        return a;
    }
    public Boolean revisarNota(int posc,EditText lisNot[]){
        Boolean s=false;
        if(lisNot[posc].length()!=0){
            if(Float.parseFloat(lisNot[posc].getText().toString())>=1.0 && Float.parseFloat(lisNot[posc].getText().toString())<=7.0){
                s=true;
            }else{
                Toast.makeText(this,"La nota debe ser entre 1.0 y 7.0",Toast.LENGTH_SHORT ).show();
            }
        }
        return s;
    }
    public void promediar(TableRow lisR[],EditText lisNot[],EditText lisPon[]){
        int sumPon=0;
        float prome=0;
        for(int l=0;l<=9;l++){
            if(lisR[l].getVisibility()== View.VISIBLE && lisPon[l].length() != 0){
                sumPon=sumPon + (Integer.parseInt(lisPon[l].getText().toString()));
            }
        }
        if(sumPon <= 100){
            for(int l=0;l<=9;l++){
                if(lisR[l].getVisibility()== View.VISIBLE && lisPon[l].length() != 0 && lisNot[l].length() != 0){
                    prome=prome+(Float.parseFloat(lisNot[l].getText().toString())*(Float.parseFloat(lisPon[l].getText().toString())/100));
                }
            }
            promFin.setText(prome+"");
            ponFin.setText(sumPon+"%");
        }else{
            Toast.makeText(this,"La ponderacion total no debe ser mayor a 100",Toast.LENGTH_SHORT ).show();
            promFin.setText(prome+"");
            ponFin.setText(sumPon+"%");
        }


    }


}
