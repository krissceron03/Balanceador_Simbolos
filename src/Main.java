import javax.management.StringValueExp;
import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //<> es template
        Scanner sc = new Scanner(System.in);
        //CREACIÓN DE PILAS
        Stack<String> pila = new Stack<String>();
        Stack<String> media = new Stack<String>();
        Stack<String> resultado = new Stack<String>();
        String cadena;
        System.out.println("------- BALANCEADOR DE SÍMBOLOS -------");
        System.out.println("Ingrese símbolos de apertura y cierre: ");
        cadena = sc.nextLine();
        int caP=0, caC=0, caLL=0, ccP=0, ccC=0, ccLL=0; //VARIABLES PARA ALMACENAR EL NÚMERO DE ELEMENTOS DE APERTURA Y CIERRE para saber si hay balance o no
        //Recorro la cadena de caracteres ingresada por el usuario, estoy añadiendo cada caracter a una pila y contando los caracteres de apertura y de cierre para saber si se puede balancear

        for (int i = 0; i < cadena.length(); i++) {
            String c = String.valueOf(cadena.charAt(i));
            pila.push(c);

            switch (c){
                case "{": {
                    caLL++;
                    //System.out.println("Encontró una llave");
                    break;
                }
                case "[": {
                    caC++;
                    //System.out.println("Encontró un corchete");
                    break;
                }
                case"(": {
                    caP++;
                    //System.out.println("Encontró un paréntesis");
                    break;
                }
                case "}": {
                    ccLL++;
                    //System.out.println("Encontró una llave de cierre");
                    break;
                }
                case "]": {
                    ccC++;
                    //System.out.println("Encontró un corchete de cierre");
                    break;
                }
                case")": {
                    ccP++;
                    //System.out.println("Encontró un paréntesis de cierre");
                    break;
                }
                default:{
                    break;
                }
            }
        }
        /*System.out.println(pila);
        System.out.println("Hay "+caP+" PARÉNTESIS DE APERTURA");
        System.out.println("Hay "+caC+" CORCHETES DE APERTURA");
        System.out.println("Hay "+caLL+" LLAVES DE APERTURA");

        System.out.println("Hay "+ccP+" PARÉNTESIS DE CIERRE");
        System.out.println("Hay "+ccC+" CORCHETES DE CIERRE");
        System.out.println("Hay "+ccLL+" LLAVES DE CIERRE");*/

        // COMPARACIÓN DE RESULTADOS para saber si se puede balancear o no

        if(caP==ccP && caC==ccC && caLL==ccLL) {
            System.out.println("Se puede balancear");

            //Se hace un barrido de la pila, se evalúa si hay carecteres de apertura en la cadena y se añade a la pila media y resultado con el objetivo de armar la cadena final de caracteres

            for(String pilita: pila){
                if(pilita.equals("(")||pilita.equals("[")||pilita.equals("{")){
                    media.push(pilita);
                    resultado.push(pilita);
                }
            }

            //se hace un barrido de la pila "media" comparando su último elemento ingresado (simbolo de apertura) para añadir su elemento de cierre respectivo
            //System.out.println("tamaño de la media "+media.size());
            for (int i=0; i<pila.size()/2; i++) {

               switch (media.peek()){
                   case "(":{
                       resultado.push(")");
                       break;}
                   case "[":{
                       resultado.push("]");
                       break;}
                   case "{":{
                       resultado.push("}");
                       break;}
                   default: {
                       break;
                   }
               }
               media.pop();
            }
            //muestra de resultados
            String cade=" ";
            for (String simbolo: resultado) {
            cade= cade+ simbolo;
            }
            //imprime en string
            System.out.println("RESULTADO BALANCEADO: "+cade);
            // imprimir la pila
            //System.out.println("RESULTADO BALANCEADO PILA RESULTADO: "+resultado);



        }
            else
            {
                System.out.println("No se puede balancear");
            }

        }
     }





