package lotto;

public class Application {
	private static User user;
	private static LotteryCommission lotteryCommission;
	private static LottoResult[] resultCheckList = {
			LottoResult.THREE,
			LottoResult.FOUR,
			LottoResult.FIVE,
			LottoResult.FIVE_BONUS,
			LottoResult.SIX
	};

	public static void main(String[] args) {
		setMoney();
		generateLotteryCommision();
		setBonusNumber();
		printResult();
	}

	private static void setMoney() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			user = new User(ConsoleReader.readNumber());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setMoney();
		}
	}

	public static void generateLotteryCommision() {
		try {
			System.out.println("당첨 번호를 입력해 주세요.");
			lotteryCommission = new LotteryCommission(ConsoleReader.readNumberList());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void setBonusNumber() {
		try {
			System.out.println("보너스 번호를 입력해 주세요.");
			lotteryCommission.setBonusNumber(ConsoleReader.readNumber());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setBonusNumber();
		}
	}

	public static void printResult() {
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
