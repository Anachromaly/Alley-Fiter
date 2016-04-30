package outline;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

import outline.Game;
import outline.Time;

import static outline.Draw.*;

public class Animation {
	
	private ArrayList<Texture> frames = new ArrayList<Texture>();
	private int fps;
	private int frame = 0;
	private Time time = new Time();
	private boolean finished = false;
	private boolean check = false;
	
	public Animation(ArrayList<Texture> frames, int fps) {
		this.frames = frames;
		this.fps = fps;
	}
	
	public Animation(String path, int fps) {
		this.fps = fps;
		int count = 0;
		do {
			Texture t;
			if((t = loadTexture(path + "/sprite_" + count + ".png", "PNG")) != null){
				frames.add(t);
				count++;
			}else {
				break;
			}
		}while(true);
	}
	
	public boolean checkFirstRun() {
		return check;
	}
	
	public boolean isDone() {
		return finished;
	}
	
	public void update() {
		if(frame > 0 && !check)
			check = true;
		if(check && frame == 0)
			finished = true;
		if(time.getTime() - time.getLastFrame() >= 1000/(fps * Game.GAME_TIME.getMulti())) {
			nextFrame();
			time.update();
		}
	}
	
	public Texture getCurrentFrame() {
		return frames.get(frame);
	}
	
	public int getFrameNum() {
		return frame;
	}
	
	public void nextFrame() {
		frame++;
		loopFrame();
	}
	
	public void lastFrame() {
		frame--;
		loopFrame();
	}
	
	public void loopFrame() {
		frame %= frames.size();
	}
	
	public Texture getFrame(int frame) {
		return frames.get(frame);
	}
	
	public void setFrame(int frame) {
		this.frame = frame;
		loopFrame();
	}
	
}
