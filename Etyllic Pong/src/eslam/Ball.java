package eslam;

import java.awt.Color;

import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.Layer;

public class Ball extends Layer{
	
	private double speed = 5;
	private double incX = 1;
	private double incY = 0;	
	
	public Ball(int x, int y){
		super(x,y);
		
		double angle = 20;
		
		incX = speed*Math.sin(Math.PI * angle / 180);
		incY = speed*Math.cos(Math.PI * angle / 180);
	}
	
	@Override
	public void draw(Graphic g){
		
		g.setColor(Color.BLACK);
		
		g.fillOval(x, y, 30, 30);
		
	}
	
	public void move(){
		this.x+=speed*incX;
		this.y+=speed*incY;
	}

	public void hitHorizontal() {
		incX = -incX;
	}

	public void hitVertical() {
		incY = -incY;
	}

}

