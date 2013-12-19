package br.com.pong.model;

import java.awt.Color;

import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.Layer;

public class Ball extends Layer{
	
	private double speed = 2.5;
	private double incX = 1;
	private double incY = 0;
	private double moveAngle = 20;
	private int hittedBy = 0;
	
	public Color color = Color.BLACK;
	
	public Ball(float x, float y){
		super(x,y,20,20);
				
		incX = speed*Math.sin(Math.PI * moveAngle / 180);
		incY = -speed*Math.cos(Math.PI * moveAngle / 180);
	}
	
	@Override
	public void draw(Graphic g){
		
		g.setColor(color);
		
		g.fillRect(x, y, w, h);
		
	}
	
	public void move(){
		this.x+=speed*incX;
		this.y+=speed*incY;
	}

	public void hitHorizontal(Paddle paddle) {
				
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
		
		if(incX<1){
			incX = 1;
		}else if(incX<-1){
			incX = -1;
		}
		
	}

	public int getHittedBy() {
		return hittedBy;
	}

	public void setHittedBy(int hittedBy) {
		this.hittedBy = hittedBy;
	}

	public double getIncX() {
		return incX;
	}

	public void setIncX(double incX) {
		this.incX = incX;
	}

	public double getIncY() {
		return incY;
	}

	public void setIncY(double incY) {
		this.incY = incY;
	}
			
}

