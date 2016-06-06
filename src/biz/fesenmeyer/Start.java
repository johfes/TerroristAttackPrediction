package biz.fesenmeyer;

import javax.annotation.Generated;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class Start {
	static final int EVENT_NUMBER = 20;
	
	public static void main(String[] args) {
	    Configuration cepConfig = new Configuration();
	    // register objects the engine will have to handle
	    cepConfig.addEventType("VehicleAtSameLocation",
	    		VehicleAtSameLocation.class.getName());
	    cepConfig.addEventType("UnusualMovementOfVehicleCloseToTarget",
	    		UnusualMovementOfVehicleCloseToTarget.class.getName());
		// setup the engine
		EPServiceProvider cep = EPServiceProviderManager.
									getProvider("CEPEngine",cepConfig);
		cep.initialize();
		EPRuntime cepRT = cep.getEPRuntime();
		//  register EPL statements
		EPAdministrator cepAdm = cep.getEPAdministrator();
		EPStatement cepStatement1 = cepAdm.createEPL("select * from " +
		                                "VehicleAtSameLocation.win:length(1) " +
		                                "where location='Finanzministerium' "+
		                                "and criticalityLevel > 2");

		EPStatement cepStatement2 = cepAdm.createEPL("select * from " +
		                                "VehicleAtSameLocation.win:length(1) " +
		                                "where location='Parlamentsgebäude' "+
		                                "and criticalityLevel > 1");
		
		EPStatement cepStatement3 = cepAdm.createEPL("select * from " +
                "UnusualMovementOfVehicleCloseToTarget.win:length(1) ");
		
		cepStatement1.addListener(new ThreatListener());
		cepStatement2.addListener(new ThreatListener());
		cepStatement3.addListener(new ThreatListener());
		
		for(int i=0; i<=EVENT_NUMBER; i++){
			EventGenerator.generateEvent(cepRT);
		}
	}
}



