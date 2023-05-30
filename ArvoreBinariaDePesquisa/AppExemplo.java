import java.util.Scanner;

public class App {
        public static void main(String[] args) {
            ArvoreBinariaDePesquisa abp = new ArvoreBinariaDePesquisa();
            Scanner entrada = new Scanner(System.in);
    
            // Adicionar elementos para a abp
            abp.adicionar(4);
            abp.adicionar(3);
            abp.adicionar(8);
            abp.adicionar(2);
            abp.adicionar(0);
            abp.adicionar(7);
            abp.adicionar(9);
            abp.adicionar(5);
    
            //abp original
    
            abp.imprimirArvore();
    
            // Verificar se a árvore está vazia
    
            System.out.println("Árvore está vazia? ");
            if (abp.estaVazia() == true) {
                System.out.println("Sim");
            } else {
                System.out.println("Não");
            }
    
            // Obter o tamanho da árvore
            System.out.println("Tamanho da árvore: " + abp.obterTamanho());
    
            // Imprimir os elementos em pré-ordem
            System.out.println("Elementos em pré-ordem: " + abp.elementosPreOrdem());
    
            // Imprimir os elementos em ordem central
            System.out.println("Elementos em ordem central: " + abp.elementosCentralOrdem());
    
            // Imprimir os elementos em pós-ordem
            System.out.println("Elementos em pós-ordem: " + abp.elementosPosOrdem());
    
            // Imprimir os elementos em largura
            System.out.println("Elementos em largura: " + abp.elementosLargura());
    
            //Entrada de um elemento 
    
            System.out.println("Informe um valor: ");
            int elemento = entrada.nextInt();
    
            // Verificar se um elemento existe na árvore
    
            System.out.println("O elemento " + elemento + " existe na árvore?");
            if (abp.existe(elemento) == true) {
                System.out.println("Sim");
            } else {
                System.out.println("Não");
            }
    
            // Obter o nível de um elemento
            if (abp.obterNivel(elemento) == -1) {
                System.out.println("O Elemento não foi encontrado ou não possui nível");
            } else {
                System.out.println("O nível do elemento " + elemento + " é: " + abp.obterNivel(elemento));
            }
    
            // Obter o elemento da esquerda de um dado elemento
            if (abp.obterEsquerda(elemento) == -1) {
                System.out.println("O Elemento não foi encontrado ou não possui filho à esquerda");
            } else {
                System.out.println("O elemento à esquerda de " + elemento + " é: " + abp.obterEsquerda(elemento));
    
            }
    
            // Obter o elemento da direita de um dado elemento
            if (abp.obterDireita(elemento) == -1) {
                System.out.println("O Elemento não foi encontrado ou não possui filho à direita");
            } else {
                System.out.println("O elemento à esquerda de " + elemento + " é: " + abp.obterDireita(elemento));
    
            }
            
            // Obter o pai de um dado elemento
            if (abp.obterPai(elemento) == -1) {
                System.out.println("O Elemento não foi encontrado ou não possui pai");
            } else {
                System.out.println("O pai do elemento " + elemento + " é: " + abp.obterPai(elemento));
            }
            
            // Verificar se um elemento é interno ou externo
            System.out.println("O elemento " + elemento + " é interno? ");
    
            if (abp.buscarInterno(elemento) == true) {
                System.out.println("Sim");
            } else {
                System.out.println("Não");
            }
    
            System.out.println("O elemento " + elemento + " é externo? ");
    
            if (abp.buscarExterno(elemento) == true) {
                System.out.println("Sim");
            } else {
                System.out.println("Não");
            }
    
            // Remover um elemento da árvore
            abp.remover(elemento);
            System.out.println("Elemento " + elemento + " removido da árvore.");
    
            // Imprimir a árvore atualizada
            System.out.println("Árvore atualizada:");
            abp.imprimirArvore();
    
            // Limpar a árvore
            abp.limpar();
            System.out.println("Árvore limpa.");
    
            // Verificar se a árvore está vazia após limpar
            System.out.println("Árvore está vazia? ");
            if (abp.estaVazia() == true) {
                System.out.println("Sim");
            } else {
                System.out.println("Não");
            }

            entrada.close();
        }
    }
