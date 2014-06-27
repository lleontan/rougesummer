
public class shieldSystem extends system{
	
	public void resetShield(){
		if(this.currentPower<0){this.currentPower=0;}
		if(this.currentPower>this.health){this.currentPower=this.health;}
		gameController.shipList.get(shipIndex).shield=this.currentPower;
	}
	@Override
	public void turnEnd() {
		
	}
	public shieldSystem(int roomindex,int level){
		this.maxPower=level;
		this.health=this.maxhealth;
		this.resetShield();
	}
	@Override
	public void turnBegin() {
		
	}

}
