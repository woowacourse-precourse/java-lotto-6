package lotto;

public class LottoController {
	private User user;
	private LotteryCommission lotteryCommission;
	private Integer bonusNumber;
	private static LottoResult[] resultCheckList = {
			LottoResult.THREE,
			LottoResult.FOUR,
			LottoResult.FIVE,
			LottoResult.FIVE_BONUS,
			LottoResult.SIX
	};

	public void run() {
		setUser();
		setLotteryCommission();
		setBonusNumber();
		printResult();
	}

	private void setUser() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			user = new User(ConsoleReader.readNumber());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setUser();
		}
	}

	private void setLotteryCommission() {
		try {
			System.out.println("당첨 번호를 입력해 주세요.");
			lotteryCommission = new LotteryCommission(ConsoleReader.readNumberList());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private void setBonusNumber() {
		try {
			System.out.println("보너스 번호를 입력해 주세요.");
			lotteryCommission.setBonusNumber(ConsoleReader.readNumber());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setBonusNumber();
		}
	}

	private void printResult() {
		Double resultMoney = 0.0;
		System.out.println("당첨 통계");
		System.out.println("---");
		for (Lotto lotto : user.getLottoList()) {
			lotto.setResult(lotteryCommission.getWinningNumbers(), lotteryCommission.getBonusNumber());
		}

		for (LottoResult result : resultCheckList) {
			int count = 0;
			for (Lotto lotto : user.getLottoList()) {
				if (result.equals(lotto.getResult())) {
					count++;
				}
			}
			System.out.println(result.message + " - " + count + "개");
			resultMoney += result.money * count;
		}
		System.out.printf("총 수익률은 %.1f%%입니다.%n", resultMoney / user.getMoney() * 100);
	}
}
