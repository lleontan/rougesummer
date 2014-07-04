
public class shieldSystem extends system{
	int shieldRegen=1;
	public void resetShield(){
		if(this.currentPower<0){this.currentPower=0;}
		if(this.currentPower>this.health){this.currentPower=this.health;}

	}
	@Override
	public void turnBegin() {
		//called on turn beginning
		if(this.currentPower>0&&
this.currentPower<gameController.shipList.get(shipIndex).shield){
		gameController.shipList.get(shipIndex).shield+=this.shieldRegen;
	}}
	public shieldSystem(int roomindex,int level,int shipIndex){
		this.maxPower=level;
		this.health=this.maxhealth;
		this.resetShield();
		this.shipIndex=shipIndex;
	}
	@Override
	public void turnEnd() {
		//called on turn ending
	}

}
