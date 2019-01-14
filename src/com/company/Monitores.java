package com.company;
/*provee exclusion mutua para la ejecucion de los metodos
* los metodos deben tener el syncronize delante*/
public class Monitores {

    private int cont =0;
    private int order = 0;

    public synchronized int inc(){
        for(int i = 0; i<20000;i++){
            cont++;
        }
        return cont;
    }


    public synchronized  void ordenar(int id){
        while(id != order){
            try {
                wait();// al ser un metodo syncronize el cerrojo lo implementa la propia clase
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("Soy el hilo: "+ id);
        order++;
        notifyAll();
    }



}
