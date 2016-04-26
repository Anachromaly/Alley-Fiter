package outline;

import org.lwjgl.Sys;

public class Time {
	
	private boolean isPaused = false;
	public long lastFrame = 0;
	public long totalTime = 0;
	private boolean firstUpdate = true;
	public float d = 0;
	public float multi = 1;
	
	public void update() {
		 d = getDelta();
		 totalTime += d;
	}
	
	public long getTime() {
		return Sys.getTime() * 1000 / Sys.getTimerResolution();
	}
	
	public long getLastFrame() {
		return lastFrame;
	}
	
	public float getDelta() {
		int delta = (int) (getTime() - lastFrame);
		lastFrame = getTime();
		return delta;
	}
	
	public void reset() {
		totalTime = 0;
		lastFrame = 0;
		firstUpdate = true;
		d =0;
	}
	
	public float Delta() {
		if(isPaused || firstUpdate) {
			firstUpdate = false;
			return 0;
		}else
			return d * multi;
	}
	
	public long getTotalTime() {
		return totalTime;
	}
	
	public float getMulti() {
		return multi;
	}
	
	public void changeSpeed(int s) {
		if(s > -1 && s < 5)
			multi = s;
	}
	
	public void pause() {
		isPaused = !isPaused;
	}
		
}
