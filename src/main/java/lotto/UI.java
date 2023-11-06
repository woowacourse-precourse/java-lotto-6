package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UI {
	LottoService lottoService = new LottoService();

	void on() {
		int NumberOfLottoTickets = inputMoney();

	}

	int inputMoney() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			String cost = Console.readLine();
			System.out.println();
			return lottoService.getNumberOfLottoTickets(cost);
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorCode.IS_NOT_COMPOSED_OF_NUMBERS.getErrorMessage());
			return inputMoney();
		}
	}
}
