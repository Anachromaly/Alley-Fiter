package outline;

public enum ItemID {
	
	Floor("floor", true);
	
	public String texture;
	public boolean walk;
	
	ItemID(String texture, boolean walk) {
		this.texture = texture;
		this.walk = walk;
	}
}
