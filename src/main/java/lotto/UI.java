package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UI {
	LottoService lottoService = new LottoService();
	long numberOfLottoTickets;
	List<Lotto> computerLottos;
	Lotto user;
	int bonusNumber;
	long profit;

	void on() {
		inputMoney();
		System.out.println("\n" + numberOfLottoTickets + "개를 구매했습니다.");
		showComputerLottos(numberOfLottoTickets);
		inputNumbers();
		inputBonusNumber(user);
		showWinningStatistics(computerLottos, user, bonusNumber);
		showProfitRates(numberOfLottoTickets, profit);
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
			this.user = lottoService.issueUserLotto(inputNumbers);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			inputNumbers();
		}
	}

	private void inputBonusNumber(Lotto user) {
		try {
			System.out.println("\n보너스 번호를 입력해 주세요.");
			String inputBonusNumber = Console.readLine();
			this.bonusNumber = lottoService.checkBonusNumber(user, inputBonusNumber);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			inputBonusNumber(user);
		}
	}

	private void showWinningStatistics(List<Lotto> computerLottos, Lotto user, int bonusNumber) {
		System.out.println("당첨 통계");
		System.out.println("---");
		List<Integer> winningResult =
				lottoService.getWinningResult(computerLottos, user, bonusNumber);
		System.out.println("3개 일치 (5,000원) - " + winningResult.get(5) + "개");
		System.out.println("4개 일치 (50,000원) - " + winningResult.get(4) + "개");
		System.out.println("5개 일치 (1,500,000원) - " + winningResult.get(3) + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningResult.get(2) + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + winningResult.get(1) + "개");
		this.profit = (5_000L * winningResult.get(5)) + (50_000L * winningResult.get(4)) +
				(1_500_000L * winningResult.get(3)) + (30_000_000L * winningResult.get(2)) +
				(2_000_000_000L * winningResult.get(1));
	}

	private void showProfitRates(long numberOfLottoTickets, long profit) {
		String profitRate = lottoService.getProfitRate(numberOfLottoTickets, profit);
		System.out.println("총 수익률은 " + profitRate + "%입니다.");
	}
}
