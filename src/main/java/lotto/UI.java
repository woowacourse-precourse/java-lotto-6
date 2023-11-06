package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UI {
	LottoService lottoService = new LottoService();

	void on() {
		long NumberOfLottoTickets = inputMoney();
		System.out.println(NumberOfLottoTickets + "개를 구매했습니다.");
	}

	long inputMoney() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			String cost = Console.readLine();
			System.out.println();
			return lottoService.getNumberOfLottoTickets(cost);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputMoney();
		}
	}
}
