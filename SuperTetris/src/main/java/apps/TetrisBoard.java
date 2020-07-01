package apps;

import blocks.Block;
import blocks.BlockBorder;
import blocks.EmptyBlock;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import listeners.TetrisListeners;
import pieces.Peca;
import pieces.PecaI;
import pieces.PecaJ;
import pieces.PecaL;
import pieces.PecaO;
import pieces.PecaS;
import pieces.PecaT;
import pieces.PecaZ;

/**
 *************************
 *                       *
 * @author Vitor Alencar * 
 *************************
 */
public class TetrisBoard extends JPanel implements ActionListener, MouseListener, KeyListener {

    Block[][] game; // conjunto de blocos

    Peca piece; // peca que se move 
    Peca piece2; // peça auxiliar para as próximas peças
    Peca piece3; // peça auxiliar para as próximas peças
    Peca piece4; // peça auxiliar para as próximas peças
    Peca piece5;// peça auxiliar para as próximas peças

    int nextPeca = 0;

    int linhas = 22;
    int colunas = 13;

    // atributo para somar os pontos do jogo
    int pontos = -4; //Começa com -4 porque 5 peças são criadas inicialmente por detrás do sistema

    // chave para verificar o final do jogo
    boolean gameOver = false;
    boolean check = false;
    boolean pause = false;

    Timer timer;

    TetrisListeners listener;

    public TetrisBoard() {
        initGame();
        // inicializar o timer
        timer = new Timer(280, this);
        timer.start();

        // por o componente a escutar o "rato"
        addMouseListener(this);

        // por o componente a escutar o teclado
        addKeyListener(this);

        // chamando o focus do "rato" para o projeto durante a execução
        this.requestFocus();

        // Verifica se há alguma linha sendo completada
        checkLine();

    }

    public void addListener(TetrisListeners t) {
        this.listener = t;
    }

    public void initGame() {

        // alocar a matriz
        game = new Block[linhas][colunas];
        // criar os blocos vazios
        for (int y = 0; y < game.length; y++) {
            for (int x = 0; x < game[y].length; x++) {

                // criar os blocos da borda
                if (x == 0 || x == (colunas - 1) || y == 0 || y == (linhas - 1)) {
                    game[y][x] = new BlockBorder();
                } else // senão cria os blocos em branco
                {
                    game[y][x] = new EmptyBlock();
                }
            }
        }
        checkLine();
        //criar a peça que se move
        piece = createNewPiece();
        piece2 = createNewPiece();
        piece3 = createNewPiece();
        piece4 = createNewPiece();
        piece5 = createNewPiece();

    }

    private Peca createNewPiece() {
        pontos++;
        checkLine();

        if (listener != null) {
            listener.onNewPiece(this);
        }

        return generateRandom();
    }

    private Peca generateRandom() {

        Peca peca;
        Random gerador = new Random();

        int number = gerador.nextInt(7);
        nextPeca = number;

        switch (number) {
            case 0:
                return new PecaL();

            case 1:
                return new PecaJ();

            case 2:
                return new PecaI();

            case 3:
                return new PecaO();

            case 4:
                return new PecaS();

            case 5:
                return new PecaZ();

            case 6:
                return new PecaT();

            default:
                System.out.println("Peça aleatória não gerada.");
        }

        return new Peca();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        int dx = getWidth() / game[0].length;
        int dy = getHeight() / game.length;

        for (int y = 0; y < game.length; y++) {
            for (int x = 0; x < game[y].length; x++) {
                // mandar desenhar os blocks
                game[y][x].draw(g, x * dx, y * dy, dx, dy);
            }
        }
        // desenhar a peça
        piece.draw(g, dx * piece.posX, dy * piece.posY, dx, dy);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        checkGameOver();
        checkLine();

        if (piece.canGoDown(game)) {
            piece.goDown(); // peça desce
        } else {
            if (gameOver && !check) {
                JOptionPane.showMessageDialog(null, "Game Over. Você conseguiu " + pontos + " pontos");
                updateHighScore();
                check = true;
                //System.exit(0);
            } else if (!gameOver) {
                piece.freezePiece(game);

                piece = piece2;
                piece2 = piece3;
                piece3 = piece4;
                piece4 = piece5;

                //peças auxiliares
                piece5 = createNewPiece();
            }

        }
        repaint();
        this.requestFocus();
    }

    public void checkGameOver() {

        // verifica se já existem blocos nas primeiras linhas onde são instanciados novos blocos
        if (game[2][6] instanceof EmptyBlock && game[2][7] instanceof EmptyBlock) {
            gameOver = false;
        } else {
            gameOver = true;
            pauseGame();

        }
    }

    public void checkLine() {

        for (int y = 1; y < game.length - 1; y++) {
            boolean delete = true;
            for (int x = 1; x < game[y].length - 1; x++) {
                if ((game[y][x] instanceof EmptyBlock)) {
                    delete = false;
                    break;
                }
            }
            if (delete) {
                excludeLine(y);
                pontos += 5;
                System.out.println("Linha eliminada: " + y + ". Somou +5 pontos");
            }

        }

    }

    public void excludeLine(int linha) {

        for (int y = linha; y > 1; y--) {
            for (int x = 1; x < game[y].length - 1; x++) {
                // tabuleiro atualiza recebendo a linha de cima
                game[y][x] = game[y - 1][x];
            }
        }
        repaint();

    }

    public int getNumPieces() {
        return this.pontos;
    }

    public Peca getPeca() {
        return this.piece;
    }

    public void pauseGame() {

        timer.stop();

    }

    public void startGame() {
        timer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        //Verifica para ir para a direita
        if (key == KeyEvent.VK_LEFT) {
            if (piece.canGoLeft(game) && !check) {
                piece.goLeft();
            }
        }

        //Verifica para ir para a esquerda
        if (key == KeyEvent.VK_RIGHT) {
            if (piece.canGoRight(game) && !check) {
                piece.goRight();
            }
        }

        //Verifica para descer a peça
        if (key == KeyEvent.VK_DOWN) {
            if (piece.canGoDown(game) && !check) {
                piece.goDown();
            }
        }

        //Verifica para rotacionar à esquerda, pressionando a letra "A"
        if (key == KeyEvent.VK_A) {
            if (piece.canRotateLeft() && !check) {
                piece.rotateLeft();
            }
        }

        //Verifica para rotacionar à direita, pressionando a letra "D"
        if (key == KeyEvent.VK_D) {
            if (piece.canRotateRight(game) && !check) {
                piece.rotateRight();
            }
        }

        if (key == KeyEvent.VK_SPACE) {
            if (!pause) {
                pauseGame();
                pause = true;

                int resposta = JOptionPane.showConfirmDialog(null, "Jogo Pausado! Pressione positivo para voltar ao jogo."
                        + " Caso negativo seja, será declarado game over", "SuperTetris 2020", JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    startGame();
                    pause = false;
                } else {
                    gameOver = true;
                    updateHighScore();
                    JOptionPane.showMessageDialog(null, "Game Over. Você conseguiu " + pontos + " pontos");
                    check = true;
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        // verificar qual o botao
        if (me.getButton() == MouseEvent.BUTTON1) {
            // mover a peça para a esquerda
            if (piece.canGoLeft(game) && !check) {
                piece.goLeft();
            }
        } else if (me.getButton() == MouseEvent.BUTTON3) {
            // mover a peça para a direita
            if (piece.canGoRight(game) && !check) {
                piece.goRight();
            }
        }
        repaint();
    }

    public void updateHighScore() {

        //Salva o número de pontos feitos
        try {
            FileWriter arq = new FileWriter("pontos");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(pontos + "");
            gravarArq.close();

        } catch (IOException e) {
            System.out.println("Erro ao gravar");
        }

        //lê os dados do atual player
        String caminho = "dados";
        String conteudo = "";

        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = "";

            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    conteudo += linha + "\n";
                    linha = lerArq.readLine();
                }
                arq.close();

            } catch (IOException e) {
                System.out.println("Erro. Não foi possível ler o arquivo. " + e);

            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro. Não foi possível encontrar o arquivo! " + e.toString());
        }

        String dados[] = conteudo.split(":");

        if (dados.length > 3) {

            // lê o ranking
            caminho = "highscore";
            conteudo = "";

            try {
                FileReader arq = new FileReader(caminho);
                BufferedReader lerArq = new BufferedReader(arq);

                String linha = "";

                try {
                    linha = lerArq.readLine();
                    while (linha != null) {
                        conteudo += linha + "\n";
                        linha = lerArq.readLine();
                    }
                    arq.close();

                } catch (IOException e) {
                    System.out.println("Erro. Não foi possível ler o arquivo. " + e);

                }

            } catch (FileNotFoundException e) {
                System.out.println("Erro. Não foi possível encontrar o arquivo! " + e.toString());
            }

            String players[] = conteudo.split("\n");
            String novoRanking = "";

            for (int i = 0; i < players.length; i++) {
                if (players[i].contains(dados[1])) {

                    String point[] = players[i].split(":");

                    int points = Integer.valueOf(point[1]);

                    if (points < pontos) {
                        players[i] = dados[1] + ":" + pontos;
                    }

                }
                novoRanking += players[i] + "\n";
            }

            //salva o novo ranking
            try {
                FileWriter arq = new FileWriter("highscore");
                PrintWriter gravarArq = new PrintWriter(arq);
                gravarArq.println(novoRanking);
                gravarArq.close();

            } catch (IOException e) {
                System.out.println("Erro ao gravar");
            }

        }

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        // quando voltar ao componente
    }

    @Override
    public void mouseExited(MouseEvent me) {
        // quando o rato sair do componente
    }

}
