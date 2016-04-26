package items;

import org.lwjgl.util.Rectangle;

import outline.Draw;
import outline.Item;
import outline.ItemID;

public class Floor extends Item {
	
	public Floor() {
		super((float)0, (float)700, (float)1280, (float)720, ItemID.Floor, new Rectangle((int)0, (int)1200, (int)1280, (int)720));
	}
	
	public void tick() {
	}
	
	public void render() {
		Draw.drawQuad(x, y , width, height, texture);
	}
}
