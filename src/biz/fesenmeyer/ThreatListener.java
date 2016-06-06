package biz.fesenmeyer;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class ThreatListener implements UpdateListener {

	@Override
	public void update(EventBean[] arg0, EventBean[] arg1) {
		System.out.println("********************************************************************************************************************************");
		System.out.println("Warning: "+ arg0[0].getUnderlying());
		System.out.println("********************************************************************************************************************************");

	}

}
