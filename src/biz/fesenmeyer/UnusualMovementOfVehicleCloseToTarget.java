package biz.fesenmeyer;

public class UnusualMovementOfVehicleCloseToTarget {
	String location;
	int criticalityLevel;
	
	public UnusualMovementOfVehicleCloseToTarget(String location, int criticalityLevel){
		this.location = location;
		this.criticalityLevel = criticalityLevel;
	}

	public String getLocation() {
		return location;
	}

	public int getCriticalityLevel() {
		return criticalityLevel;
	}

	@Override
	public String toString() {
		return "UnusualMovementOfVehicleCloseToTarget \n[location=" + location
				+ ", criticalityLevel=" + criticalityLevel + "]";
	}
	
}
