package br.com.pong.menu;


import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.Action;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.gui.Button;
import br.com.etyllica.gui.label.TextLabel;
import br.com.pong.PongApplication;

public class MainMenu extends Application {

	private Button play;

	public MainMenu(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {
				
		int bw = 250;
		int bh = 50;
		
		play = new Button(w/2-bw/2,190,bw,bh);
		
		TextLabel playLabel = new TextLabel("PLAY");
		
		play.setLabel(playLabel);
		play.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "playPong"));
		
		add(play);

		loading = 100;
	}
	
	public void playPong(){
		this.returnApplication = new PongApplication(w, h);
	}
	

	@Override
	public void draw(Graphic g) {

	}


	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {

		return null;
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {

		return null;
	}

}
