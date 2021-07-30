package fbuni;

//ESTA CLASSE DEVE SE OBRIGATORIAMENTE MANTIDA NO PROJETO. QUALQUER ALTERA��O REALIZADA DEVE OBEDECER A HIERARQUIA
//ELA DEVE SER UTILIZADA NA HERAN�A DE DESENHOS QUE POSSAM SER MOVIMENTADOS PELO USU�RIO 
public class DesenhoMovel extends Desenho {
	
	public DesenhoMovel() {}
	
	public DesenhoMovel(int x, int y, String path) {
		super(x, y, path);
	}
	
	public void moverDireita() throws ForaDaTelaException {
		if(this.getX() >= 650) {
			throw new ForaDaTelaException();
		}
		this.setX(this.getX() + 10);
	}
	
	public void moverEsquerda() throws ForaDaTelaException {
		if(this.getX() <= 100) {
			throw new ForaDaTelaException();
		}
		this.setX(this.getX() - 10);
	}
	
	public void moverCima() throws ForaDaTelaException {
		if(this.getY() <= 20) {
			throw new ForaDaTelaException();
		}
		this.setY(this.getY() - 10);
	}
	
	public void moverBaixo() throws ForaDaTelaException {
		if(this.getY() >= 650) {
			throw new ForaDaTelaException();
		}
		this.setY(this.getY() + 10);
	}
}
