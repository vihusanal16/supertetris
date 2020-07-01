package pieces;

import blocks.Block;
import blocks.BlockBorder;
import blocks.EmptyBlock;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *************************
 *                       *
 * @author Vitor Alencar * 
 *                       *
 *************************
 */

public class Peca extends JComponent {

    public static Color transparent = new Color(0f, 0f, 0f, 0f);
    // posicao dentro do jogo
    public int posX = 6; // coordenada X
    public int posY = 1; // coordenada Y

    Block matrix[][]; //matriz de cores
    
    public Peca(Peca p){
        this(p.matrix);
    }

    public Peca() {
        this.matrix = matrix;
    }

    public Peca(Block[][] matrix) {
        this.matrix = matrix;
    }

    public int getSquareWidth() {
        return this.getWidth() / matrix.length;
    }

    public int getSquareHeight() {
        return this.getHeight() / matrix[0].length;
    }

    public void rotateLeft() {
        transpose();
        horizontalMirror();
    }

    public void rotateRight() {
        transpose();
        verticalMirror();
    }

    private void transpose() {
        Block[][] tmp = new Block[matrix[0].length][matrix.length];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                //copiar para tmp
                tmp[x][y] = matrix[y][x];
            }
        }
        matrix = tmp;
        repaint();
    }

    private void verticalMirror() {

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length / 2; x++) {
                //copiar para tmp
                Block tmp = matrix[y][x];
                matrix[y][x] = matrix[y][matrix[0].length - x - 1];
                matrix[y][matrix[0].length - x - 1] = tmp;
            }
        }

        repaint();

    }

    private void horizontalMirror() {

        for (int y = 0; y < matrix.length / 2; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                //copiar para tmp
                Block tmp = matrix[y][x];
                matrix[y][x] = matrix[matrix.length - y - 1][x];
                matrix[matrix.length - y - 1][x] = tmp;
            }
        }

        repaint();
    }

    public void freezePiece(Block[][] game) {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if(!(matrix[y][x] instanceof EmptyBlock))
                    game[posY + y][posX + x] = matrix[y][x];
            }
        }
    }

    /**
     * verifica se uma peca pode cair
     *
     * @param game matriz do jogo
     * @return true se poder
     */
    public Boolean canGoDown(Block[][] game) {
        // chegou ao final da matriz
        if (posY + matrix.length >= game.length) {
            return false;
        }

        // existem posições livres para cair
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                // bloco de baixo esta ocupada
                if (!(game[posY + y + 1][posX + x] instanceof EmptyBlock) && !(matrix[y][x] instanceof EmptyBlock)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean canRotateRight(Block[][] game){
        
        if (posX + matrix.length > game[0].length - 1) {
            return false;
        }

        return true;
    }
    
    public boolean canRotateLeft(){
        // Não será problema rotacionar para a esquerda
        return true;
    }

    public Boolean canGoLeft(Block[][] game) {

        // chegou ao limite direito da matriz
        if (posX <= 0) {
            return false;
        }

        // existem posições livres à sua direita
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                // Verifica se o bloco de baixo está livre e também se é possível encaixar
                if (!(game[posY + y][posX + x - 1] instanceof EmptyBlock) && !(matrix[y][x] instanceof EmptyBlock)) {
                    return false;
                }
            }
        }
        return true;

    }

    public void goLeft() {
        posX--; // incrementa a posição horizontal
    }

    public Boolean canGoRight(Block[][] game) {
        // chegou ao limite direito da matriz
        if (posX + matrix[0].length >= game[0].length) {
            return false;
        }

        // existem posições livres à sua direita
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                // celula de baixo esta ocupada
                if (!(game[posY + y][posX + x + 1] instanceof EmptyBlock)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void goRight() {
        posX++; // incrementa a posição horizontal
    }

    public void goDown() {
        posY++; // incrementa a posição vertical
    }
    
    

    /**
     * desenhar as peças nas coordenadas do contexto gráfico
     *
     * @param g contexto gráfico
     * @param px coordenada X do canto superior esquerdo
     * @param py coordenada Y do canto superior esquerdo
     * @param dx largura dos blocos
     * @param dy altura dos blocos
     */
    public void draw(Graphics g, int px, int py, int dx, int dy) {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                matrix[y][x].draw(g, px + x * dx, py + y * dy, dx, dy);
            }
        }
    }

    /**
     * desenha o componete
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        int w = getWidth();
        int h = getHeight();

        // dividir a figura pelas dimensões da peça
        int dx = w / matrix[0].length; // número de colunas
        int dy = h / matrix.length; // número de linhas

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                matrix[y][x].draw(g, x * dx, y * dy, dx, dy);
            }
        }
    }
    
    
}

