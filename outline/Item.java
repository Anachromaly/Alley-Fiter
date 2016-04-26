package outline;

import org.newdawn.slick.opengl.Texture;
import org.lwjgl.util.Rectangle;

import static outline.Draw.*;

public abstract class Item {
	private float x, y, xSpeed, ySpeed, width, height;
	protected Texture texture;
	protected Rectangle hitbox;
	protected ItemID id;
	
	public Item(float _x, float _y, float _height, float _width, ItemID _id, Rectangle _hitbox) {
		x = _x;
		y = _y;
		width= _width;
		height = _height;
		hitbox = _hitbox;
		id = _id;
		texture = loadTexture(id.texture, "png");
	}

	public float getX() {
		return x;
	}
	
	public void setX(float _x) {
		x = _x;
	}
	
	public float getY() {
		return y;
	}
	public void setY(float _y) {
		y = _y;
	}
	
	public float getXSpeed() {
		return xSpeed;
	}
	
	public void setXSpeed(float _xSpeed) {
		xSpeed = _xSpeed;
	}
	
	public float getYSpeed() {
		return ySpeed;
	}
	
	public void setYSpeed(float _ySpeed) {
		ySpeed = _ySpeed;
	}
	
	public float getWidth() {
		return width;
	}
	
	public void setWidth(float _width) {
		width = _width;
	}
	
	public float getHeight() {
		return height;
	}
	
	public void setHeight(float _height) {
		height = _height;
	}
	
	public Rectangle getHitBox() {
		return hitbox;
	}
	
	public void setHitBox(Rectangle _hitbox) {
		hitbox = _hitbox;
	}
	
	public ItemID getID() {
		return id;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public void setTexture(Texture text) {
		texture = text;
	}
	
}
