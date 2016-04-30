package items;

import org.lwjgl.util.Rectangle;

import outline.Draw;
import outline.Item;
import outline.ItemID;

public class Floor extends Item {
	
	public Floor() {
		super(0, 450, 1024, 16, ItemID.Floor, new Rectangle((int)0, (int)480, (int)1024, (int)16));
	}
	
	public void render() {
		Draw.drawQuad(x, y, width, height, texture);
	}
	
	public void tick() {
	}
	
	public void drawHealth() {
	}
	
}
