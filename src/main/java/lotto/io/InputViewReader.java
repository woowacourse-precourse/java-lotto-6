package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public final class InputViewReader implements Reader {

	@Override
	public String readLine() {
		return Console.readLine();
	}
}