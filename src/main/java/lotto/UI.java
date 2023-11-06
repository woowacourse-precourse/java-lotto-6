package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UI {
	LottoService lottoService = new LottoService();

	void on() {
		long numberOfLottoTickets = inputMoney();
		System.out.println("\n" + numberOfLottoTickets + "개를 구매했습니다.");
		showComputerLottos(numberOfLottoTickets);
		List<Integer> userNumbers = inputNumbers();
	}

	private long inputMoney() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			String cost = Console.readLine();
			return lottoService.getNumberOfLottoTickets(cost);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputMoney();
		}
	}

	private void showComputerLottos(long numberOfLottoTickets) {
		try {
			List<Lotto> lottos = lottoService.issueLottos(numberOfLottoTickets);
			for (int i = 0; i < lottos.size(); i++) {
				System.out.println(lottos.get(i).getNumbers());
			}
			System.out.println();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			on();
		}
	}

	private List<Integer> inputNumbers() {
		try {
			System.out.println("\n당첨 번호를 입력해 주세요.");
			String inputNumbers = Console.readLine();
			List<Integer> userNumbers = lottoService.checkNumbers(inputNumbers);
			return userNumbers;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputNumbers();
		}
	}
}
