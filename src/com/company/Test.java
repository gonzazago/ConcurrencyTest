package com.company;

public class Test {

    private int i = 0;
    static int j = 3;
    protected  int k = 4;
    public int b =1;

    public void metodoPublic(){
        System.out.println("Metodo Publico");
    }

    protected void metodoProtected(){
        System.out.println("Metodo Protected");
    }

    private void metodoPrivate(){
        System.out.println("Metodo private");
    }

    public static void main(String... args){
        Test t = new Test();

        System.out.println("Valor private: " + t.i);
        System.out.println("Valor public: " + t.b);
        System.out.println("Valor protected: " + t.k);
        System.out.println("Valor default:" + t.j);

        t.metodoPrivate();
        t.metodoProtected();
        t.metodoPublic();
    }
}
