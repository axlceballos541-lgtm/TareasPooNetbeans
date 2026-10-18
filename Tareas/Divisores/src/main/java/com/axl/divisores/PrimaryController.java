package com.axl.cifrasyduvisores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable{
    
    @FXML private TextField txt1,txt2,txt3,txt4,txt5,txt6,txt7;
    @FXML private TextArea txtarea;
    int num;
    @FXML
    private void Analizar(){
       num=Integer.parseInt(txt1.getText());
       txt2.setText(""+cant_cifras());
       txt3.setText(""+suma_impar());
       txt4.setText(""+suma_par());
       txt5.setText(""+(suma_par()+suma_impar()));
       txt6.setText(""+mayor());
       txt7.setText(""+menor());
       for(int l=1;l<=num;l++){
        if(divisores(l)){
            txtarea.appendText(""+l+"\n");
            }
       }
    }
     @FXML
    private void Limpiar(){
     txt1.setText("");
     txt2.setText("");
     txt3.setText("");
     txt4.setText("");
     txt5.setText("");
     txt6.setText("");
     txt7.setText("");
     txtarea.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public int cant_cifras(){
    int cifras=0;
    int num1=num;
    while(num1!=0){
    num1=num1/10;
    cifras++;
    }
    return cifras;
    }
    public int suma_impar(){
    int suma=0;
    int num2=num;
    int control=cant_cifras();
    int[] digito=new int[control];
    for(int j=0;j<control;j++){
    digito[j]=num2%10;
    num2=num2/10;
    }
    for(int i=0;i<control;i++){
    if(digito[i]%2==0){
        }else{
    suma=suma+digito[i];
    }
    }
    return suma;
    }
    public int suma_par(){
    int suma=0;
    int num2=num;
    int control=cant_cifras();
    int[] digito=new int[control];
    for(int j=0;j<control;j++){
    digito[j]=num2%10;
    num2=num2/10;
    }
    for(int i=0;i<control;i++){
    if(digito[i]%2==0)suma=suma+digito[i];
    }
    return suma;
    }
    public int mayor(){
    int num3=num;
    int control=cant_cifras();
    int[] digito=new int[control];
    for(int j=0;j<control;j++){
    digito[j]=num3%10;
    num3=num3/10;
    }
    int mayor=digito[0];
    for(int i=0;i<control;i++){
    if(mayor<digito[i])mayor=digito[i];
    }
    return mayor;
    }
    public int menor(){
    int num4=num;
    int control=cant_cifras();
    int[] digito=new int[control];
    for(int j=0;j<control;j++){
    digito[j]=num4%10;
    num4=num4/10;
    }
    int mayor=digito[0];
    for(int i=0;i<control;i++){
    if(mayor>digito[i])mayor=digito[i];
    }
    return mayor;
    }
    public boolean divisores(int x){
      int num5=num;
      if(num5%x==0){
         return true;
      }else{
         return false;
      }
    }
    
}