package biz.fesenmeyer;

import java.util.Random;

import com.espertech.esper.client.EPRuntime;

public class EventGenerator {
	
	public static void generateEvent(EPRuntime cepRT){
		if(generateRandomInt(1, 10) < 9){
			generateVehicleAtSameLocation(cepRT);
		} else {
			generateUnusualMovementOfVehicleCloseToTarget(cepRT);
		}
	}
	
	public static void generateVehicleAtSameLocation(EPRuntime cepRT){
		VehicleAtSameLocation vehicleAtSameLocation = 
				new VehicleAtSameLocation(generateLocation(), 
									generateCriticalityLevel());
		System.out.println(vehicleAtSameLocation);
		cepRT.sendEvent(vehicleAtSameLocation);
	}
	
	public static void generateUnusualMovementOfVehicleCloseToTarget(EPRuntime cepRT){
		UnusualMovementOfVehicleCloseToTarget unusualMovementOfVehicleCloseToTarget = 
				new UnusualMovementOfVehicleCloseToTarget(generateLocation(), generateCriticalityLevel());
		System.out.println(unusualMovementOfVehicleCloseToTarget);
		cepRT.sendEvent(unusualMovementOfVehicleCloseToTarget);
	}
	
	public static int generateCriticalityLevel(){
		if(generateRandomInt(1, 10) < 9){
			return 1;
		} else {
			return generateRandomInt(2, 3);
		}
		
	}
	
	public static String generateLocation(){
		if(generateRandomInt(1, 10) > 7){
			return "Parlamentsgebäude";
		} else {
			return "Finanzministerium";
		}
	}
	
	public static int generateRandomInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}

}



