import Materia.controllers.AVLTree;
import Materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree ab = new BinaryTree();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);

        
        //ab.imprimirArbol();
        System.out.println();
        ab.imprimirArbolIn();
        System.out.println();
        ab.imprimirArbolPos();
        System.out.println();
        ab.imprimirArbolPre();
        System.out.println();

        if(ab.findeValue(23)){
            System.out.println("Encontro el valor 23");
        }else{
            System.out.println("No encontro el valor 23");
        }

        if(ab.findeValue(77)){
            System.out.println("Encontro el valor 77");
        }else{
            System.out.println("No encontro el valor 77");
        }

        System.out.println();

        System.out.println("Nombre: Alexander Beltran");
        System.out.println("Peso del arbol");
        System.out.println(ab.imprimirPeso());
        System.out.println("Arbol inOrder");
        ab.imprimirArbolIn();
        System.out.println();
        System.out.println("Altura del arbol InOrder");
        ab.imprimirArbolInH();
        System.out.println();
        System.out.println("Arbol con valores en equilibrio");
        ab.imprimirArbolInE();
        System.out.println();
        System.out.println("Arbol esta equulibrado= "+ab.arbolEquilibrado());


        if(ab.findeValue(15)){
            System.out.println("Encontro el valor 15");
        }else{
            System.out.println("No encontro el valor 15");
        }

        ab.insert(15);
        System.out.println("Valor 15 agregado");
        System.out.println("Arbol esta equlibrado= "+ab.arbolEquilibrado());
        
        System.out.println("Arbol con factor de equilibrio InOrder");
        ab.imprimirArbolInE();
        System.out.println();
        ab.nodosDesequilibrados();

        System.out.println("---------------------");

        AVLTree avl = new AVLTree();
        avl.insert(5);
        avl.insert(20);
        avl.insert(15);
        avl.inOrder();
    }
}
