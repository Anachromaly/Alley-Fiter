package outline;

import static outline.Draw.Background;
import static outline.Draw.Setup;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import outline.Item;
import outline.Time;

public class Game {
	
	public static int state = 0;
	public final static Time GAME_TIME = new Time();
	public static ArrayList<Item> items = new ArrayList<Item>();
	
	public Game() {
		Setup();
		
		while(!Display.isCloseRequested()) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			if(state == 0) {
				state = 1;
			}else if(state == 1) {
				GAME_TIME.update();
				Background();
			}
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}

	public static void main(String[] args) {
		new Game();
	}
}