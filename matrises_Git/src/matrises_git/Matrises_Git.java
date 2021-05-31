/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrises_git;

/**
 *
 * @author Camilo Fabian Uriana
 */
public class Matrises_Git {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        matrizd m = new matrizd();
        m.creadispersa(2, 3);
        m.adicionar(1, 3, 7);
        m.adicionar(1, 1, 6);
        m.adicionar(2, 2, 8);
        m.adicionar(2, 3, 9);
        matrizd m1 = m.nuevo(m, 2);
        m1.imprimir_toda();
        //int c=m.contar_fila(2);
        //System.out.println(c);
        //boolean b=m.mayor(1, 2);
        //System.out.println(b1);
        //m.imprimir_toda();
        //System.out.println("/////////////////////////");
        //int c[]=m.dimensiones();
        //System.out.println(c[0]+" "+c[1]);
//        m.imprimir_columna(3);
//        m.imprimir_fila(2);
//        m.elementos_columna(2);
//        m.elementos_fila(2);
//        m.imprimir_fila_multiplicada(1, 3);
    }
    
    static void suma (matrizd x,matrizd c)
    {
        
    }
}

class matrizd {
    
    nodo cab;
    
    matrizd() {
        cab = new nodo(0, 0, 0);
        cab.sigfil = cab.sigcol = cab;
    }
    
    void creadispersa(int x, int y) {
        int i = 1;
        nodo aux = cab;
        int j = 1;
        while (j <= y) {
            nodo nuevo = new nodo(0, j, 0);
            nuevo.sigcol = aux.sigcol;
            nuevo.sigfil = nuevo;
            aux.sigcol = nuevo;
            aux = nuevo;
            j = j + 1;
        }
        aux = cab;
        while (i <= x) {
            nodo nuevo1 = new nodo(i, 0, 0);
            nuevo1.sigfil = aux.sigfil;
            nuevo1.sigcol = nuevo1;
            aux.sigfil = nuevo1;
            aux = nuevo1;
            i = i + 1;
        }
    }

    void adicionar(int x, int y, int z) {//Crea un nuevo nodo enlazandolo con los nodos vecinos
        nodo aux,aux1,aux2;
        aux=cab;
        while (aux.col<y)
        {
            aux=aux.sigcol;
        }
        aux1=aux.sigfil;
        aux2=aux1.sigfil;
        while (aux1.fil<x&&aux2.fil!=0)
        {
            aux=aux1;
            aux1=aux.sigfil;
            aux2=aux.sigfil;
        }
        nodo arriba;
        if (aux1.fil<x)
        {
            arriba=aux1;
        }
        else 
        {
            arriba=aux;
        }
        nodo aux6=arriba.sigfil;
        nodo aux3, aux4, aux5, izquierda;
        aux3=cab;
        while(aux3.fil<x)
        {
            aux3=aux3.sigfil;
        }
        aux4=aux3.sigcol;
        aux5=aux4.sigcol;
        while (aux4.col<y&&aux5.col!=0)
        {
            aux3=aux4;
            aux4=aux4.sigcol;
            aux5=aux4.sigcol;
        }
        if(aux4.col<y)
        {
            izquierda=aux4;
        }
        else
        {
            izquierda=aux3;
        }
        nodo aux7=izquierda.sigcol;
        nodo nuevo=new nodo(x,y,z);
        nuevo.sigcol=aux7;
        nuevo.sigfil=aux6;
        arriba.sigfil=nuevo;
        izquierda.sigcol=nuevo;
    }

    


    void imprimir_fila(int x) {
        nodo aux=cab;
        while (aux.fil<x)
        {
            aux=aux.sigfil;
        }
        nodo aux1=aux.sigcol;
        while(aux1!=aux)
        {
            System.out.println("Fila : "+aux1.fil+" Columna : "+aux1.col+" Info : "+aux1.info);
            aux1=aux1.sigcol;
        }
    }
    
    void imprimir_columna(int x) {
        nodo aux=cab;
        while (aux.col<x)
        {
            aux=aux.sigcol;
        }
        nodo aux1=aux.sigfil;
        while(aux1!=aux)
        {
            System.out.println("Fila : "+aux1.fil+" Columna : "+aux1.col+" Info : "+aux1.info);
            aux1=aux1.sigfil;
        }
    }
    
    void elementos_fila(int x){
        nodo aux1=cab;
        while (aux1.fil<x)
        {
            aux1=aux1.sigfil;
        }
        nodo aux=aux1.sigcol;
        int c=0;
        while(aux1!=aux)
        {
            c=c+1;
            aux=aux.sigcol;
        }
        System.out.println("Elementos de la columna: "+x);
        System.out.println(c);
    }
    void elementos_columna(int x){
        nodo aux1=cab;
        while (aux1.col<x)
        {
            aux1=aux1.sigcol;
        }
        nodo aux=aux1.sigfil;
        int c=0;
        while(aux1!=aux)
        {
            c=c+1;
            aux=aux.sigfil;
        }
        System.out.println("Elementos de la columna: "+x);
        System.out.println(c);
    }
    void imprimir_fila_multiplicada(int x, int z)
    {
        nodo aux1=cab;
        while (aux1.fil<x)
        {
            aux1=aux1.sigfil;
        }
        nodo aux=aux1.sigcol;
        while(aux1!=aux)
        {
            System.out.println(aux.info*z);
            aux=aux.sigcol;
        }
    }
    void imprimir_columna_multiplicada(int x, int z){
        nodo aux1=cab;
        while (aux1.col<x)
        {
            aux1=aux1.sigcol;
        }
        nodo aux=aux1.sigfil;
        while(aux1!=aux)
        {
            System.out.println(aux.info*z);
            aux=aux.sigfil;
        }
    }
    int [] arreglo (int x, int z)
    {
        nodo aux=cab;
        int c[]= new int [2];
        while (aux.fil<x)
        {
            aux=aux.sigfil;
        }
        nodo aux1=aux.sigcol;
        while(aux1!=aux)
        {
            c[0]=c[0]+1;
            aux1=aux1.sigcol;
        }
        nodo aux2=cab;
        while (aux2.fil<z)
        {
            aux2=aux2.sigfil;
        }
        nodo aux3=aux2.sigcol;
        while(aux3!=aux2)
        {
            c[1]=c[1]+1;
            aux3=aux3.sigcol;
        }
        return c;
    }
    int [] dimensiones ()
    {
        nodo aux=cab.sigfil;
        int c[]= new int [2];
        while (aux!=cab)
        {
            c[0]=c[0]+1;
            aux=aux.sigfil;
        }
        aux=cab.sigcol;
        while (aux!=cab)
        {
            c[1]=c[1]+1;
            aux=aux.sigcol;
        }
        return c;
    }
    int contar_fila (int x)
    {
        int c=0;
        nodo aux=cab;
        while (aux.fil<x)
        {
            aux=aux.sigfil;
        }
         nodo aux1=aux.sigcol;
        while(aux1!=aux)
        {
            c=c+1;
            aux1=aux1.sigcol;
        }
        return c;

    }
    boolean   mayor (int x, int y)
       {
        int c=0;
        int d=0;
        c=contar_fila(x);
        d=contar_fila(y);
        boolean b = (c>d)? true:false;
        return b;
       }
    void imprimir_toda ()
    {
        nodo aux=cab.sigfil;
        //nodo aux1=cab.sigfil;
        while(aux!=cab)
        {
            nodo este=aux.sigcol;
            while(este!=aux)
            {
                System.out.println(este.info);
                este=este.sigcol;
            }
            aux=aux.sigfil;
        }
        
    }
    
    matrizd nuevo (matrizd m, int c)
    {
        matrizd x = new matrizd();
        int a[]=m.dimensiones();
        x.creadispersa(a[0], a[1]);
        nodo aux=m.cab.sigcol;
        while (aux!=m.cab)
        {
            nodo aux1=aux.sigfil;
            while (aux1!=aux)
            {
                x.adicionar(aux1.fil, aux1.col, aux1.info*c);
                aux1=aux1.sigfil;
            }
            aux=aux.sigcol;
        }
//        aux=m.cab.sigcol;
//        while (aux!=m.cab)
//        {
//            x.adicionar(aux.col, aux.fil, aux.info*c);
//            aux=aux.sigcol;
//        }
//        m.cab=x;
//        nodo aux=cab.sigfil;
//        while (aux!=cab)
//        {
//            aux.info=aux.info*c;
//            aux=aux.sigfil;
//        }
//        aux=cab.sigcol;
//        while (aux!=cab)
//        {
//            aux.info=aux.info*c;
//            aux=aux.sigcol;
//        }
        return x;
    }
}

class nodo {
    
    int fil;
    int col;
    int info;
    
    nodo(int x, int y, int z) {
        fil = x;
        col = y;
        info = z;
    }
    nodo sigfil;
    nodo sigcol;
}

