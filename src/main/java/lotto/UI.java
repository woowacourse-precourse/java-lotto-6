package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UI {
	LottoService lottoService = new LottoService();

	void on() {
		input();
	}

	void input() {
		String cost = Console.readLine();
	}
}
