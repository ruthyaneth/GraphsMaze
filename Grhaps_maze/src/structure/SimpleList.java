package structure;
import java.util.Comparator;
/**
 * UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA
 * FACULTAD DE INGENIERIA.
 * ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION.
 * PRESENTADO A: Ing Helver Valero.
 * PROGRAMACION III
 * Clase simplelist que remplaza un arrayList.
 * @author Adrian Parra, Jenny Quesada, Daniel Reyes , Ruth Rojas
 */
public class SimpleList<T> {

    private Node<T> head;
    private Comparator<T> comparator;

    public SimpleList() {
        this.head = null;
    }

    public SimpleList(Comparator<T> comparator) {
        this.head = null;
        this.comparator = comparator;
    }
    
    public int size(){
        Node<T> aux;
        int count=0;
        aux = head;
 
        //Recorremos
        while(aux != null){
            count++;
            aux = aux.getNext();
        }
        return count;
 
    }
    
    public Node<T> devolverNodo(int pos){
        Node<T> aux=head;
        int cont=0;
         
        if(pos<0 || pos>=size()){
            System.out.println("La posicion insertada no es correcta");
        }else{
            //recorremos
            while(aux!=null){
                if (pos == cont){
                    //Devuelvo aux, con esto salimos de la función
                    return aux; 
                }
                 
                //Actualizo el siguiente
                aux=aux.getNext();
                cont++;
                 
            }
        }
         
        return aux;
         
    }

    /**
     * verificar si la cabeza del nodo esta vacia
     *
     * @return
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Adiciona un elemento al final de la lista.
     *
     * @param info objeto a adicionar.
     */
    public void add(T info) {
        if (this.head==null) {
            this.head = new Node<T>(info);
        } else {
            Node<T> node = this.head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(new Node<T>(info));
        }
    }
    

    /**
     * Inserta un elemento al final de la lista.
     *
     * @param info
     */
    public void insert(T info) {
        this.head = new Node<T>(info, this.head, null);
    }

    /**
     * Insertar info ordenado segun un criterio.
     */
    public void addSort(T info) {
        Node<T> temporal = new Node<T>(info);
        if (isEmpty()) {
            this.head = temporal;
        } else {
            Node<T> node = this.head;
            Node<T> node1 = node.getNext();
            while (node1 != null && (comparator.compare(temporal.getInfo(), node1.getInfo())) < 0) {
                node = node1;
                node1 = node1.getNext();
            }
            if (node == this.head && (comparator.compare(node.getInfo(), temporal.getInfo())) < 0) {
                temporal.setNext(head);
                this.head = temporal;
            } else {
                temporal.setNext(node.getNext());
                node.setNext(temporal);
            }
        }
    }

    /**
     * insertar un elemento en una posicion especifica de la lista
     *
     * @param info objeto a insertar
     * @param index posicion en la cual insertar el objeto
     */
    public void insertAt(T info, int index) {
        Node<T> insertion = new Node<T>(info);
        Node<T> initial = this.head;
        Node<T> previous = null;

        for (int i = 1; i < index; i++) {
            previous = initial;
            initial = initial.getNext();
        }

        if (initial == this.head) {
            insertion.setNext(head);
            head = insertion;
        } else {
            previous.setNext(insertion);
            insertion.setNext(initial);
        }
    }

    /**
     * metodo para borrar un objeto
     *
     * @param index posicion del elemento a borrar
     */
    public void eraseAt(int index) {
        Node<T> aux = null;
        Node<T> initial = this.head;
        Node<T> next = initial.getNext();
        for (int i = 0; i < index; i++) {
            aux = initial;
            initial = next;
            next = next.getNext();
        }
        if (initial == this.head) {
            this.head = next;
        } else {
            aux.setNext(next);
        }
    }

    public void addInOrder(T inf) {
        Node<T> tmp = new Node<T>(inf);
        tmp.setInfo(inf);
        if (head == null) {
            head = tmp;

        } else {
            Node<T> aux = head.getNext();
            Node<T> aux1 = head;
            while (aux != null
                    && (comparator.compare(tmp.getInfo(), aux.getInfo())) < 0) {
                aux1 = aux;
                aux = aux.getNext();
            }
            if (aux1 == head
                    && (comparator.compare(aux1.getInfo(), tmp.getInfo())) < 0) {
                tmp.setNext(head);
                head = tmp;
            } else {
                tmp.setNext(aux1.getNext());
                aux1.setNext(tmp);

            }
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

}