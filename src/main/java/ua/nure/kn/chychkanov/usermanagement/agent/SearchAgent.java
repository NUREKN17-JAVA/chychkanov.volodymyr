package ua.nure.kn.chychkanov.usermanagement.agent;

import jade.core.Agent;

public class SearchAgent extends Agent {

	@Override
	protected void setup() {
		super.setup();
		System.out.print(getAID().getName() + " sarted");
	}

	@Override
	protected void takeDown() {
		System.out.println(getAID().getName() + " terminated");
		super.takeDown();
	}

}
