
public class shieldSystem extends system{
	
	public void resetShield(){
		if(this.currentPower<0){this.currentPower=0;}
		if(this.currentPower>this.health){this.currentPower=this.health;}

	}
	@Override
	public void turnEnd() {
		
	}
	public shieldSystem(int roomindex,int level,int shipIndex){
		this.maxPower=level;
		this.health=this.maxhealth;
		this.resetShield();
		this.shipIndex=shipIndex;
	}
	@Override
	public void turnBegin() {
		
	}

}
