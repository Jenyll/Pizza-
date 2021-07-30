package fbuni;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Principal extends JFrame implements KeyListener {

	private Desenho avenida;
	private Jogador jogador;
	private List<Pizza> pizzas = new ArrayList<>();
	private static Random rand = new Random();
	private FPSLimiter fpsCounterLimiter = new FPSLimiter();
	private static final long serialVersionUID = 1L;

	public Principal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Desenhando a tela e seus elementos
		avenida = new Desenho(0, 0, "street.png");
		jogador = new Jogador(420, 530, "index.jpg");

		for (int i = 0; i < 10; i++)
			pizzas.add(new Pizza(110 + rand.nextInt(500), -100 - rand.nextInt(1000), "pizza.png"));
		// Adicionando o evento de teclado
		this.addKeyListener(this);
	}

	
	public static void main(String[] args) {
		Principal t = new Principal();
		t.setSize(840, 650);
		t.createBufferStrategy(1);
		t.setVisible(true);
		t.createBufferStrategy(2);
	}

	
	@Override
	public void paint(Graphics ignore) {
		BufferStrategy strategy = getBufferStrategy();
		do {
			do {
				Graphics graphics = strategy.getDrawGraphics();
				renderizarImagens(graphics);
				graphics.dispose();
			} while (strategy.contentsRestored());
			strategy.show();
		} while (strategy.contentsLost());
		repaint();
	}

	
	public void renderizarImagens(Graphics g2) {
		// Desenhando as imagens
		bateu();
		avenida.desenhar(g2);
		jogador.desenhar(g2);
		pizzas.forEach(p -> p.desenhar(g2));
		fpsCounterLimiter.draw(g2);
	}

	public void bateu() {
		pizzas.forEach(p -> {
			if (jogador.getRectangle().intersects(p.getRectangle())) {
				p.setX(100 + rand.nextInt(500));
				p.setY(-110 - rand.nextInt(1000));
			}

			if (p.getY() >= 630) {
				JOptionPane.showMessageDialog(null, "Acabou o jogo!");
				System.exit(NORMAL);
			}
		});
	}

	public void keyPressed(KeyEvent evt) {
		// Especificando o comportamento das teclas
		try {
			if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
				jogador.moverDireita();
				repaint();
			} else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
				jogador.moverEsquerda();
				repaint();
			} else if (evt.getKeyCode() == KeyEvent.VK_UP) {
				jogador.moverCima();
				repaint();
			} else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
				jogador.moverBaixo();
				repaint();
			}
		} catch (ForaDaTelaException e) {
			System.out.println("Limite da tela atingido");
		}
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}
}
