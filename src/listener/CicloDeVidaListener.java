package listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class CicloDeVidaListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {
//		System.out.println("depois da fase" + event.getPhaseId());
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
//		System.out.println("antes da fase" + event.getPhaseId());
		
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.ANY_PHASE;
	}

}
