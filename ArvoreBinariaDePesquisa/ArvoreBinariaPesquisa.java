import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class ArvoreBinariaDePesquisa {
    class Nodo {
        public int item;
        public Nodo pai;
        public Nodo esquerda;
        public Nodo direita;
        public Nodo(int item) {
            this.item = item;
            this.pai = null;
            this.esquerda = null;
            this.direita = null;
        }
        
    }
    private Nodo raiz;
    private int tamanho;
    public ArvoreBinariaDePesquisa() {
        tamanho = 0;
    }

    private Nodo obterNodo(int item){

        Nodo aux = raiz;

        while(aux != null){

            if(aux.item == item) return aux;

            if(aux.item > item) aux = aux.esquerda;
            else if(aux.item < item) aux = aux.direita;

        }

        return null;

    }

    private void adicionarRecursivamente(Nodo novoNodo, Nodo pai) {
        if(novoNodo.item < pai.item) { //vai para a esquerda do nodo pai
            if(pai.esquerda==null) {
                pai.esquerda = novoNodo;
                novoNodo.pai = pai;
            }
            else adicionarRecursivamente(novoNodo, pai.esquerda);
        }
        else {
            if(pai.direita==null) {
                pai.direita = novoNodo;
                novoNodo.pai = pai;
            }
            else adicionarRecursivamente(novoNodo, pai.direita);
        }
    }
    public void adicionar(int item) {
        Nodo novoNodo = new Nodo(item);
        if(this.tamanho==0) this.raiz = novoNodo;
        else adicionarRecursivamente(novoNodo, raiz);
        this.tamanho++;
    }


    public boolean estaVazia(){

        if(tamanho==0) return true;
        return false;

    }

    public int obterTamanho(){

        return tamanho;

    }

    public void limpar(){

        tamanho=0;
        raiz=null;

    }

    public int obterEsquerda(int item){
        if(obterNodo(item).esquerda != null) return obterNodo(item).esquerda.item;
        return -1;
    }

    public int obterDireita(int item){ 
        if(obterNodo(item).direita != null) return obterNodo(item).direita.item;
        return -1;
    }

    public int obterPai(int item){
        if(obterNodo(item).pai != null) return obterNodo(item).pai.item;
        return -1;
    }

    public ArrayList<Integer> elementosPreOrdem() {
        ArrayList<Integer> lista = new ArrayList<>();
        preOrdemRecursivo(raiz, lista);
        return lista;
    }

    private void preOrdemRecursivo(Nodo nodo, ArrayList<Integer> lista) {
        if (nodo == null) {
            return;
        }
        lista.add(nodo.item);
        preOrdemRecursivo(nodo.esquerda, lista);
        preOrdemRecursivo(nodo.direita, lista);
    }

    public ArrayList<Integer> elementosCentralOrdem() {
        ArrayList<Integer> lista = new ArrayList<>();
        centralOrdemRecursivo(raiz, lista);
        return lista;
    }

    private void centralOrdemRecursivo(Nodo nodo, ArrayList<Integer> lista) {
        if (nodo == null) {
            return;
        }
        centralOrdemRecursivo(nodo.esquerda, lista);
        lista.add(nodo.item);
        centralOrdemRecursivo(nodo.direita, lista);
    }

    public ArrayList<Integer> elementosPosOrdem() {
        ArrayList<Integer> lista = new ArrayList<>();
        posOrdemRecursivo(raiz, lista);
        return lista;
    }

    private void posOrdemRecursivo(Nodo nodo, ArrayList<Integer> lista) {
        if (nodo == null) {
            return;
        }
        posOrdemRecursivo(nodo.esquerda, lista);
        posOrdemRecursivo(nodo.direita, lista);
        lista.add(nodo.item);
    }

    public ArrayList<Integer> elementosLargura() {
        ArrayList<Integer> lista = new ArrayList<>();
        if (raiz == null) {
            return lista;
        }

        Queue<Nodo> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            Nodo nodo = fila.poll();
            lista.add(nodo.item);

            if (nodo.esquerda != null) {
                fila.add(nodo.esquerda);
            }
            if (nodo.direita != null) {
                fila.add(nodo.direita);
            }
        }

        return lista;
    }

    public int obterNivel(int item) {
        Nodo nodo = obterNodo(item);
        if (nodo == null) {
            return -1; // Elemento não encontrado
        }

        int nivel = 0;
        while (nodo != null) {
            nodo = nodo.pai;
            nivel++;
        }
        return nivel - 1;
    }

    public int altura() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }
        int alturaEsquerda = calcularAltura(nodo.esquerda);
        int alturaDireita = calcularAltura(nodo.direita);
        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    public boolean buscarInterno(int item) {
        Nodo nodo = obterNodo(item);
        if(nodo != null && (nodo.esquerda != null || nodo.direita != null)) return true;
        else return false;
    }

    public boolean buscarExterno(int item) {
        Nodo nodo = obterNodo(item);
        if(nodo != null && nodo.esquerda == null && nodo.direita == null) return true;
        else return false;
    }

    public boolean existe(int item){
        if(obterNodo(item) != null) return true;
        return false;
    }

    public void remover(int item){

        Nodo aux = obterNodo(item);

        if(aux.item == item){
            if(aux.item < aux.pai.item) aux.pai.esquerda = null;
            else if(aux.item > aux.pai.item) aux.pai.direita = null;
        }

    }

    public void imprimirArvore() {
        imprimirArvoreRecusivamente(this.raiz, 0);
    }
    private void imprimirArvoreRecusivamente(Nodo raiz, int nivel) {
        if (raiz == null) return;
        nivel += 5;
        imprimirArvoreRecusivamente(raiz.direita, nivel);
        System.out.print("\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        System.out.print(raiz.item + "\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        imprimirArvoreRecusivamente(raiz.esquerda, nivel);
    }
}
