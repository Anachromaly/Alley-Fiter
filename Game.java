package outline;

import static outline.Draw.Background;
import static outline.Draw.Setup;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;




import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;



public class Game {
	

	
	/**
	 * Creates a game object composed of an ArrayList of objects that are in the game
	 */
	public Game() {
		Setup();
		
		while(!Display.isCloseRequested()) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			Background();
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}

	public static void main(String[] args) {
		new Game();
	}
}