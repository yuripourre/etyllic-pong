import eslam.PongApplication;
import br.com.etyllica.Etyllica;


public class Pong extends Etyllica{

	public Pong() {
		super(640, 480);
	}

	@Override
	public void startGame() {
		setMainApplication(new PongApplication(w, h));
	}
	
}
