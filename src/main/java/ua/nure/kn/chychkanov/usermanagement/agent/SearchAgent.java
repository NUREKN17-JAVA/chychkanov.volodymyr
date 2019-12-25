package ua.nure.kn.chychkanov.usermanagement.agent;

import java.util.Collection;
import jade.core.AID;
import jade.core.Agent;
import ua.nure.kn.chychkanov.usermanagement.db.DaoFactory;
import ua.nure.kn.chychkanov.usermanagement.db.DatabaseException;

public class SearchAgent extends Agent {

	protected void takeDown() {
		System.out.println(getAID().getName() + " terminated");
		super.takeDown();
	}

	public void search(String firstName, String lastName) throws Exception {
		try {
			Collection users = DaoFactory.getInstance().getUserDao().find(firstName, lastName);
			if (users.size() > 0) {
				showUsers(users);
			} else {
				addBehaviour(new SearchRequestBehaviour(new AID[] {}, firstName, lastName));
			}
		} catch (DatabaseException e) {
			throw new Exception();
		}

	}

	private void showUsers(Collection user) {
	}

}