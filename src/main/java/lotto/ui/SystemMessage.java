package lotto.ui;

import java.text.NumberFormat;

public class SystemMessage {

	private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
	private static final String LOTTO_STATISTICS = "\n당첨 통계\n---";
	private static final String INPUT_LOTTO_NUMBERS = "\n당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER = "\n보너스 번호을 입력해 주세요.";
	private static final String BUY_LOTTO_COUNT = "\n%d개를 구매했습니다.";
	private static final String TOTAL_REVENUE_RATE = "총 수익률은 %.1f%%입니다.";

	public static String inputMoney() {
		return INPUT_MONEY;
	}

	public static String lottoStatistics() {
		return LOTTO_STATISTICS;
	}

	public static String inputLottoNumbers() {
		return INPUT_LOTTO_NUMBERS;
	}

	public static String inputBonusNumber() {
		return INPUT_BONUS_NUMBER;
	}

	public static String lottoResults(String matchCondition, Integer prize, Long count) {
		String prizeFormat = NumberFormat
				.getInstance()
				.format(prize);
		return matchCondition
				+ " (" + prizeFormat + "원) "
				+ "- " + count + "개";
	}

	public static String buyLottoCount(Integer count) {
		return String.format(BUY_LOTTO_COUNT, count);
	}

	public static String totalRevenueRate(Double revenueRate) {
		return String.format(TOTAL_REVENUE_RATE, revenueRate);
	}
}
