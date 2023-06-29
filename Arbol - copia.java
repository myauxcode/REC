package arbolesbinariosbusqueda;

import java.util.LinkedList;

public class Arbol {

    public Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Nodo insertar(Nodo p, int x) {
        if (p == null) {
            return new Nodo(x);
        }
        if (x < p.elem) {
            p.izq = insertar(p.izq, x);
        } else {
            p.der = insertar(p.der, x);
        }
        return p;
    }

    public void insertar(int x) {
        raiz = insertar(raiz, x);
    }

    public void preOrden(Nodo p) {
        if (p == null) {
            return;
        }
        System.out.println(p.elem);
        preOrden(p.izq);
        preOrden(p.der);
    }

    public void niveles() {
        LinkedList<Nodo> L1 = new LinkedList();
        L1.add(raiz);
        while (!L1.isEmpty()) {
            Nodo p = L1.getFirst();
            System.out.println(p.elem);
            if (p.izq != null) {
                L1.add(p.izq);
            }
            if (p.der != null) {
                L1.add(p.der);
            }
            L1.removeFirst();
        }
    }

    //6. A1.seEncuentra(x) : Métodos lógico que devuelve True, si el elemento x, se encuentra en el árbol A1.
    public boolean seEncuentra(int x) {
        return buscarElemento(raiz, x);
    }

    private boolean buscarElemento(Nodo nodo, int x) {
        if (nodo == null) {
            // Si el nodo es nulo, el elemento no se encuentra en el árbol
            return false;
        }

        if (nodo.elem == x) {
            // Si el elemento se encuentra en el nodo actual, devuelve true
            return true;
        }

        // Recursivamente busca el elemento en el subárbol izquierdo y derecho
        boolean seEncuentraIzq = buscarElemento(nodo.izq, x);
        boolean seEncuentraDer = buscarElemento(nodo.der, x);

        // El elemento se encuentra en el árbol si se encuentra en el subárbol izquierdo o derecho
        return seEncuentraIzq || seEncuentraDer;
    }

    //7. A1.cantidad() : Método que devuelve la cantidad de nodos del árbol A1.
    public int cantidad() {
        return contarNodos(raiz);
    }

    private int contarNodos(Nodo nodo) {
        if (nodo == null) {
          
            return 0;
        }
        
        int cantidadIzq = contarNodos(nodo.izq);
        int cantidadDer = contarNodos(nodo.der);

       
        return cantidadIzq + cantidadDer + 1;
    }

    //8. A1.suma() : Método que devuelve la suma de los elementos del árbol A1.
    public int suma() {
        return calcularSuma(raiz);
    }

    private int calcularSuma(Nodo nodo) {
        if (nodo == null) {
            // Si el nodo es nulo, la suma es 0
            return 0;
        }

        int sumaIzq = calcularSuma(nodo.izq);
        int sumaDer = calcularSuma(nodo.der);

        return sumaIzq + sumaDer + nodo.elem;
    }

    // 9. A1.menor() : Método que devuelve el elemento menor del árbol A1.
    public int menor() {
        return encontrarMenor(raiz);
    }

    private int encontrarMenor(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }
        if (nodo.izq == null) {
            // Si no hay un nodo izquierdo, el nodo actual contiene el elemento menor
            return nodo.elem;
        }
        // Recursivamente busca en el subárbol izquierdo para encontrar el elemento menor
        return encontrarMenor(nodo.izq);
    }

    //10. A1.mayor() : Método que devuelve el elemento mayor del árbol A1.
    public int mayor() {
        return encontrarMayor(raiz);
    }

    private int encontrarMayor(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }
        if (nodo.der == null) {
            // Si no hay un nodo derecho, el nodo actual contiene el elemento mayor
            return nodo.elem;
        }
        // Recursivamente busca en el subárbol derecho para encontrar el elemento mayor
        return encontrarMayor(nodo.der);
    }

}
