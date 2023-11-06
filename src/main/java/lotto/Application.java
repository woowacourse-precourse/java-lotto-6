package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

	private static Integer money;
	private static LotteryCommission lotteryCommission;
	private static List<Lotto> lottoList = new ArrayList<>();
	private static LottoResult[] resultCheckList = {
			LottoResult.THREE,
			LottoResult.FOUR,
			LottoResult.FIVE,
			LottoResult.FIVE_BONUS,
			LottoResult.SIX
	};

	public static void main(String[] args) {
		setMoney();
		setLottoList();
		generateLotteryCommision();
		setBonusNumber();
		printResult();
	}

	private static void setMoney() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			money = ConsoleReader.readNumber();

			if (money % 1000 != 0) {
				throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력 가능합니다!");
			}
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

	public static void setLottoList() {
		Integer lottoCount = money / 1000;
		System.out.println(lottoCount + "개를 구매했습니다.");
		for (int i = 0; i < lottoCount; i++) {
			Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUMBER, Constants.LOTTO_MAX_NUMBER, Constants.WINNING_NUMBER_LENGTH));
			System.out.println(lotto);
			lottoList.add(lotto);
		}
	}

	public static void printResult() {
		Double resultMoney = 0.0;
		System.out.println("당첨 통계");
		System.out.println("---");
		for (Lotto lotto : lottoList) {
			lotto.setResult(lotteryCommission.getWinningNumbers(), lotteryCommission.getBonusNumber());
		}

		for (LottoResult result : resultCheckList) {
			int count = 0;
			for (Lotto lotto : lottoList) {
				if (result.equals(lotto.getResult())) {
					count++;
				}
			}
			System.out.println(result.message + " - " + count + "개");
			resultMoney += result.money * count;
		}
		System.out.printf("총 수익률은 %.1f%%입니다.%n", resultMoney / money * 100);
	}
}
