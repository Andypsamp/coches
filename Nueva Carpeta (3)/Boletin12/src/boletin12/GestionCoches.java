/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin12;

import javax.swing.JOptionPane;

/**
 *Programa para gestion de coches
 * @author apenasampedro
 * 
 * @version 1.0
 */
public class GestionCoches {
   static int numerodeCoches;
    String matricula;
    long time_start,time_end,complete_time,factura;
      int pago;
      /**
       * Metodo comprobar garage
       * 
       * @return si hay o no sitio
       * 
       */
    public boolean comprobarGarage(){
     boolean sitio=false;//no hay espacio  
       String respuesta=JOptionPane.showInputDialog("Introduce el numero de coches:");
        int coches=Integer.parseInt(respuesta);
    int espacios=5;
    if (coches<=espacios){
       sitio=true;
    JOptionPane.showMessageDialog(null, "Hay sitio");
        }
    else{
        JOptionPane.showMessageDialog(null, "No hay sitio");
        sitio=false;
    } 
        return sitio;
}
    
    /**
     *Metodo aparcar
     * 
     * @return tiempo en q demora en aparcar
     * 
     */
    public long aparcar(){
     if(this.comprobarGarage()){  
         time_start = System.currentTimeMillis();
        matricula= JOptionPane.showInputDialog("Introduce Matrícula");
numerodeCoches ++;
JOptionPane.showMessageDialog(null, "Aparca el coche");
 }return time_start;
     }

    /**
     *Metodo salida
     * @return tiempo en q sale el coche
     */
    public long salida(){
        numerodeCoches--;
        time_end=System.currentTimeMillis();
        JOptionPane.showMessageDialog(null, "Salida del coche:");
        return time_end;
    }

    /**
     *metodo calcular tiempo
     */
    public void calcularTiempo(){
this.aparcar();
this.salida();
complete_time=(time_end-time_start)/1000;
if (complete_time<3){
    JOptionPane.showMessageDialog(null, "Debes pagar:0.40 euros");
  } 
else{
    factura=(int)(((40+(complete_time/3)-1)*0.2f)*0.4f);
   JOptionPane.showMessageDialog(null, "Debes pagar:"+((40+(complete_time/3)-1)*0.2f)*0.4f +"euros");
  }          
  }
    
    /**
     *
     * @return pago
     */
    public int calcularFactura(){
      this.calcularTiempo();
      JOptionPane.showMessageDialog(null, "El coche de matricula:"+matricula);
      JOptionPane.showMessageDialog(null,"Ha tardado: "+ ( time_end - time_start )/1000 +"Segundos:");
          pago=Integer.parseInt(JOptionPane.showInputDialog("Pague:"+factura+"euros"));
          if(pago==factura){
           JOptionPane.showMessageDialog(null, "Gracias por su visita:");
          }
     else if(pago>factura){
        JOptionPane.showInternalMessageDialog(null, "Vuelto:"+(pago-factura)+"Gracias");
      }
      else{
          JOptionPane.showMessageDialog(null, "Pago insuficiente"+pago+"+\nPague:");
     
      }return pago; 
    }
    
    
    
  }
   













   


