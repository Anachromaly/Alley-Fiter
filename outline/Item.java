package outline;

import org.newdawn.slick.opengl.Texture;
import org.lwjgl.util.Rectangle;

import static outline.Draw.*;

public abstract class Item {
	protected float x, y, xSpeed, ySpeed, width, height;
	protected Texture texture;
	protected Rectangle hitbox;
	protected ItemID id;
	
	public Item(float _x, float _y, float _width, float _height, ItemID _id, Rectangle _hitbox) {
		x = _x;
		y = _y;
		height = _height;
		width= _width;
		id = _id;
		hitbox = _hitbox;
		texture = loadTexture(id.texture, "png");
	}
	
	public abstract void render();
	
	public abstract void drawHealth();
	
	public abstract void tick();
	
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
