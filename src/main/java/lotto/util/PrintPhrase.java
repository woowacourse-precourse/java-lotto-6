package lotto.util;

public class PrintPhrase {
	public static final String FORMAT_ONE_DICIMAL = "#.##";
	public static final String FORMAT_PRICE = "###,###";
	public static final String COMMA = ",";
	public static final String BLANK = " ";
	public static final String BRACKET_START = "(";
	public static final String BRACKET_END = ")";
	public static final String LINE = "-";

	public static class InputMessage {
		public static final String MSG_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
		public static final String MSG_WINNING_NUMS = "당첨 번호를 입력해 주세요.";
		public static final String MSG_BONUS_NUMS = "보너스 번호를 입력해 주세요.";
	}

	public static class OutputMessage {
		public static final String MSG_LOTTO_QUANTITY = "개를 구매했습니다.";
		public static final String MSG_WINNING_STATISTICS = "당첨 통계";
		public static final String MSG_LINE = "---";
		public static final String MSG_WINNING_WITH_BONUSNUM = "5개 일치, 보너스 볼 일치";
		public static final String MSG_WINNING_WITHOUT_BONUSNUM = "개 일치";
		public static final String MSG_MONEY_UNIT = "원";
		public static final String MSG_COUNT_UNIT = "개";
		public static final String MSG_RATE_OF_RETURN_FIRST = "총 수익률은 ";
		public static final String MSG_RATE_OF_RETURN_END = "%입니다.";
	}

}
