package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UI {
	LottoService lottoService = new LottoService();
	long numberOfLottoTickets;
	List<Lotto> computerLottos;
	List<Integer> userNumbers;
	int bonusNumber;

	void on() {
		inputMoney();
		System.out.println("\n" + numberOfLottoTickets + "개를 구매했습니다.");
		showComputerLottos(numberOfLottoTickets);
		inputNumbers();
		inputBonusNumber(userNumbers);
	}

	private void inputMoney() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			String cost = Console.readLine();
			numberOfLottoTickets = lottoService.getNumberOfLottoTickets(cost);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			inputMoney();
		}
	}

	private void showComputerLottos(long numberOfLottoTickets) {
		try {
			List<Lotto> lottos = lottoService.issueLottos(numberOfLottoTickets);
			for (int i = 0; i < lottos.size(); i++) {
				System.out.println(lottos.get(i).getNumbers());
			}
			computerLottos = lottos;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			on();
		}
	}

	private void inputNumbers() {
		try {
			System.out.println("\n당첨 번호를 입력해 주세요.");
			String inputNumbers = Console.readLine();
			this.userNumbers = lottoService.checkNumbers(inputNumbers);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			inputNumbers();
		}
	}

	private void inputBonusNumber(List<Integer> userNumbers) {
		try {
			System.out.println("\n보너스 번호를 입력해 주세요.");
			String inputBonusNumber = Console.readLine();
			this.bonusNumber = lottoService.checkBonusNumber(userNumbers, inputBonusNumber);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			inputBonusNumber(userNumbers);
		}
	}
}
