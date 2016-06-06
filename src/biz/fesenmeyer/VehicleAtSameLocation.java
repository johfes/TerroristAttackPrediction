package biz.fesenmeyer;

public class VehicleAtSameLocation {
	String location;
	int criticalityLevel;
	
	public VehicleAtSameLocation(String location, int criticalityLevel){
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
		return "VehicleAtSameLocation \n[location=" + location
				+ ", criticalityLevel=" + criticalityLevel + "]";
	}
	
	

}
