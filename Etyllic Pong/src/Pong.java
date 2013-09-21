import br.com.etyllica.Etyllica;
import br.com.pong.PongApplication;


public class Pong extends Etyllica{
	
	private static final long serialVersionUID = 8792778651569371426L;

	public Pong() {
		super(640, 480);
	}

	@Override
	public void startGame() {
		setMainApplication(new PongApplication(w, h));
	}
	
}
