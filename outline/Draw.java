package outline;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Draw {
	
	public static final int WIDTH = 1024, HEIGHT = 512;
	private static Texture background;
	
	public static void Setup() 																			
	{
		if(System.getProperty("os.name").contains("Windows")) 											
			System.setProperty("org.lwjgl.librarypath", new File("natives/windows").getAbsolutePath()); 
		else if(System.getProperty("os.name").contains("Mac")) 											
			System.setProperty("org.lwjgl.librarypath", new File("natives/macosx").getAbsolutePath());  
		else {
			System.out.println("Your OS is not supported"); 					
			System.exit(0); 													
		}
		
		Display.setTitle("Alley Fiter, or something..."); 	
		
		try { 																	
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT)); 				
			Display.create(); 													
		} catch(LWJGLException e) {											
			e.printStackTrace(); 												
		}
			
		glMatrixMode(GL_PROJECTION); 											
		glLoadIdentity(); 														
		glOrtho(0, WIDTH, HEIGHT, 0, 91, -1); 										
		glMatrixMode(GL_MODELVIEW); 											
		
		background = loadTexture("textures/background.png", "PNG");
	}
	
	public static void startTrans() {
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	public static void endTrans() {
		glDisable(GL_BLEND);
	}
	
	public static void Background() {
		drawQuad(0, 0, WIDTH, HEIGHT, background);
		glColor3d(1, 1, 1);
	}
	
	public static void drawQuad(float x, float y, float width, float height) {
		glDisable(GL_TEXTURE_2D); 												
		
		glBegin(GL_QUADS);
		
		glVertex2f(x, y);
		glVertex2f(x + width, y);
		glVertex2f(x + width,y + height);
		glVertex2f(x, y + height);
		
		glEnd();
	}
	
	public static void drawQuad(float x, float y, float width, float height, Texture texture) {		
		glEnable(GL_TEXTURE_2D); 															 
		texture.bind();	  																	  
		glTranslatef(x, y, 0);													  
		
		glBegin(GL_QUADS);
		
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		
		glEnd(); 
		
		glLoadIdentity(); 
	}

	public static void drawQuad(float x, float y, float width, float height, float r, float g, float b) {
		glDisable(GL_TEXTURE_2D);
		
		glBegin(GL_QUADS);
		
		glColor3f(r, g, b);
		glVertex2f(x, y);
		glVertex2f(x+width, y);
		glVertex2f(x+width, y+height);
		glVertex2f(x, y+height);
		glColor3f(1,1,1);
		
		glEnd();
	}
	
	public static Texture loadTexture(String path, String type) {
		try {
			return TextureLoader.getTexture(type, new FileInputStream(new File(path)));
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Texture quickLoad(String path) {
		return loadTexture("textures/" + path + ".png", "png");
	}
}