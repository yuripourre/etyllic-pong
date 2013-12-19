package br.com.pong.model;

import java.awt.Color;

import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.Layer;

public class Paddle extends Layer{

	private int id;
	
	private int score = 0;

	public Paddle(int id, float x, float y){
		super(x,y,15,80);
		
		this.id = id;
	}

	@Override
	public void draw(Graphic g){

		g.setColor(Color.BLACK);

		g.fillRect(x, y, w, h);

	}

	public boolean collideBall(Ball ball){

		if(ball.getHittedBy()!=id){

			if(this.colideRect(ball.getX(), ball.getY(), ball.getW(), ball.getH())){

				ball.setHittedBy(id);

				ball.hitHorizontal(this);
				
				return true;
			}
			
		}
		
		return false;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
