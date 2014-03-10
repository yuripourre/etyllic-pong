import br.com.etyllica.Etyllica;
import br.com.etyllica.context.Application;
import br.com.pong.menu.MainMenu;


public class Pong extends Etyllica {
	
	private static final long serialVersionUID = 8792778651569371426L;

	public Pong() {
		super(640, 480);
	}

	@Override
	public Application startApplication() {
		return new MainMenu(w, h);
	}
	
}
