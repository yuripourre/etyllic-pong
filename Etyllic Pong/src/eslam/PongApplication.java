package eslam;

import java.awt.Color;

import br.com.etyllica.core.application.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyboardEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.event.Tecla;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.Layer;

public class PongApplication extends Application{

	private Paddle paddle1;
	private Paddle paddle2;
	private Ball ball;

	public PongApplication(int w, int h) {
		super(w, h);

		/*
		 * deltaY = P2_y - P1_y;
			deltaX = P2_x - P1_x;

			angle = Math.atan2(deltaY, deltaX) * 180 / PI;

			double sin = Math.sin(Math.PI * angle / 180);
		 */
	}

	@Override
	public void load() {
		paddle1 = new Paddle(20,20);
		paddle2 = new Paddle(w-20-15,20);
		ball = new Ball(w/2-30/2, h/2-30/2);

		updateAtFixedRate(60);

		loading = 100;
	}

	@Override
	public void draw(Graphic g) {

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, w, h);

		drawLines(g);

		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);

	}

	private void drawLines(Graphic g){

		Color lineColor = Color.BLUE;
		Color floorColor = Color.WHITE;

		g.setColor(lineColor);

		g.drawLine(w/2, 0, w/2, h);

		g.setColor(floorColor);
		g.fillCircle(w/2, h/2, 20);

		g.setColor(lineColor);
		g.drawCircle(w/2, h/2, 20);

		/*int areaSize = 60;
		g.drawRect(-1, h/2-areaSize, areaSize, areaSize*2);
		g.drawRect(w-areaSize, h/2-areaSize, areaSize, areaSize*2);*/
	}

	final int PADDLE_KEYBOARD_SPEED = 20;
	boolean paddleUP = false;
	boolean paddleDOWN = false;

	@Override
	public GUIEvent updateKeyboard(KeyboardEvent event) {

		if(event.getPressed(Tecla.TSK_UP_ARROW)){
			paddleUP = true;
			paddleDOWN = false;
		}else if(event.getReleased(Tecla.TSK_UP_ARROW)){
			paddleUP = false;
		}

		if(event.getPressed(Tecla.TSK_DOWN_ARROW)){
			paddleDOWN = true;
			paddleUP = false;
		}
		else if(event.getReleased(Tecla.TSK_DOWN_ARROW)){
			paddleDOWN = false;
		}

		return null;
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {

		paddle1.setY(event.getY());

		return null;
	}

	public void timeUpdate(){

		if((ball.getX()<0)||(ball.getX()>w)){
			//TODO PLACAR
			ball.setCoordinates(w/2-30/2, h/2-30/2);
			ball.setMoveAngle(30);
		}

		if((ball.getY()<0)||(ball.getY()>h)){
			ball.hitVertical();
		}

		ball.move();

		if(paddleUP)
			paddle2.setY(paddle2.getY()-PADDLE_KEYBOARD_SPEED);
		else if (paddleDOWN){
			paddle2.setY(paddle2.getY()+PADDLE_KEYBOARD_SPEED);
		}

		if(paddle1.colideRect(ball.getX(), ball.getY(), ball.getW(), ball.getH())){
			ball.hitHorizontal(paddle1);
			ball.color = Color.GREEN;			
		}

		if(paddle2.colideRect(ball.getX(), ball.getY(), ball.getW(), ball.getH())){
			ball.hitHorizontal(paddle2);
			ball.color = Color.RED;
		}

	}

	/*private boolean colideCircleRect(Layer rect, Layer circle){

		double circleDistanceX = Math.abs(circle.getX() - rect.getX());
		double circleDistanceY = Math.abs(circle.getY() - rect.getY());

		if (circleDistanceX > (rect.getW()/2 + circle.getW()/2)) { return false; }
		if (circleDistanceY > (rect.getH()/2 + circle.getW()/2)) { return false; }

		if (circleDistanceX <= (rect.getW()/2)) { return true; } 
		if (circleDistanceY <= (rect.getH()/2)) { return true; }

		double cornerDistance_sq = (circleDistanceX - rect.getW()/2)*(circleDistanceX - rect.getW()/2) +
				(circleDistanceY - rect.getH()/2)*(circleDistanceY - rect.getH()/2);

		return (cornerDistance_sq <= (circle.getW()));
	}*/


}
