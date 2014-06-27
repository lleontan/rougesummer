
public abstract class system extends cosmeticSprite{
	public int maxPower=4,currentPower=4,maxLevel=10,currentLevel=4;
	public int health=4,maxhealth=4;
	int roomIndex,shipIndex;
	public boolean disabled=false;
	public abstract void turnEnd();
	public abstract void turnBegin();
}
