package lotto;

public class Constants {
    public enum Numbers {
        ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);

        private final int value;

        private Numbers(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    public static final int END_NUMBER = 45;
    public static final double PRICE_OF_LOTTO = 1000.0;
    public static final String SEPARATOR = ",";
    public static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    public static final String WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---";
    public static final String THREE_MATCHES_MESSAGE = Numbers.THREE + "개 일치 (5,000원) - ";
    public static final String FOUR_MATCHES_MESSAGE = Numbers.FOUR + "개 일치 (50,000원) - ";
    public static final String FIVE_MATCHES_MESSAGE = Numbers.FIVE + "개 일치 (1,500,000원) - ";
    public static final String FIVE_MATCHES_WITH_BONUS_MESSAGE = Numbers.FIVE + "개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String SIX_MATCHES_MESSAGE = Numbers.SIX + "개개 일치 (2,000,000,000원) - ";
    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String NUMBER_RANGE_ERROR = ERROR_MESSAGE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
}
