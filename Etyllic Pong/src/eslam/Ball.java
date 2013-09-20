package eslam;

import java.awt.Color;

import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.Layer;

public class Ball extends Layer{
	
	private double speed = 5;
	private double incX = 1;
	private double incY = 0;
	private double moveAngle = 20;
	
	public Color color = Color.BLACK;
	
	public Ball(int x, int y){
		super(x,y,30,30);
				
		incX = speed*Math.sin(Math.PI * moveAngle / 180);
		incY = speed*Math.cos(Math.PI * moveAngle / 180);
	}
	
	@Override
	public void draw(Graphic g){
		
		g.setColor(color);
		
		g.fillOval(x, y, w, h);
		
	}
	
	public void move(){
		this.x+=speed*incX;
		this.y+=speed*incY;
	}

	public void hitHorizontal(Layer paddle) {
		
		//incX = -incX;
		
		double P1_x = paddle.getX()+paddle.getW()/2;
		double P1_y = paddle.getY()+paddle.getH()/2;
		
		double P2_x = x+w/2;
		double P2_y = y+h/2;
		
		double deltaY = P2_y - P1_y;
		double deltaX = P2_x - P1_x;

		angle = Math.atan2(deltaY, deltaX) * 180 / Math.PI;

		setMoveAngle(angle);
		
	}

	public void hitVertical() {
		incY = -incY;
	}

	public double getMoveAngle() {
		return moveAngle;
	}

	public void setMoveAngle(double moveAngle) {
		this.moveAngle = moveAngle;
		incX = speed*Math.sin(moveAngle);
		incY = speed*Math.cos(moveAngle);
	}
	
}

