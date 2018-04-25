package controler;

import dao.MessageBean;

public class VerifyUtils {

	public static void checkMessage(MessageBean msg) throws Exception {
		if (msg == null) {
			throw new Exception("Le message est nulle");

		} else if (msg.getAuthor() == null) {
			throw new Exception("L'utilisateur est nulle");

		} else if (msg.getAuthor().getName() == null || msg.getAuthor().getName().trim().length() == 0) {
			throw new Exception("Le nom de l'utilisateur est nulle");

		}
	}

}
