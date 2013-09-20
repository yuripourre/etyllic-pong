package eslam;

import java.awt.Color;

import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.Layer;

public class Paddle extends Layer{
		
	public Paddle(int x, int y){
		super(x,y,15,80);
	}
	
	@Override
	public void draw(Graphic g){
		
		g.setColor(Color.BLACK);
		
		g.fillRect(x, y, w, h);
		
	}

}
