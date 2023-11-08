package Domain;

import camp.nextstep.edu.missionutils.Console;

public class ConsleManager {
	public String Input;

	public ConsleManager() {

	}

	public String readLine() {
		Input = Console.readLine();
		return Input;
	}
}
