package fbuni;


public class Jogador extends DesenhoMovel {

	public Jogador() {}
	
	public Jogador(int x, int y, String path) {
		super(x, y, path);
		redimensionar(50,100);
	}
}
