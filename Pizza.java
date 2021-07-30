package fbuni;

//ESTA CLASSE FOI CRIADA AQUI APENAS COMO EXEMPLO. O ALUNO DEVE SUBSTITUI-LA POR OUTRA CLASSE CONFORME O PROJETO.
public class Pizza extends DesenhoAnimado {

	private Thread t = new Thread(this);

	public Pizza() {
	}

	public Pizza(int x, int y, String path) {
		super(x, y, path);
		redimensionar(30, 30);
		t.start();
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		while (true) {

			this.setY(this.getY() + 5);

			try {
				t.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}