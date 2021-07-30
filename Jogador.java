package fbuni;

//ESTA CLASSE FOI CRIADA AQUI APENAS COMO EXEMPLO. O ALUNO DEVE SUBSTITUI-LA POR OUTRA CLASSE CONFORME O PROJETO.
public class Jogador extends DesenhoMovel {

	public Jogador() {}
	
	public Jogador(int x, int y, String path) {
		super(x, y, path);
		redimensionar(50,100);
	}
}
