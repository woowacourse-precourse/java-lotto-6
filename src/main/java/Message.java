public class Message {
    public static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요. ";
    public static final String LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요. ";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요. ";
    public static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";

    private static final String ERROR = "[ERROR]";
    public static final String NOT_A_NUMBER_EXCEPTION = ERROR + " 숫자만 입력해주세요. ";
    public static final String ZERO_EXCEPTION_MESSAGE = ERROR + " 0보다 큰 숫자를 입력해주세요. ";
    public static final String INDIVISIBLE_BY_UNIT_PRICE_EXCEPTION_MESSAGE = ERROR + " 구입 단위에 맞는 금액을 입력해주세요. 구입 단위: ";
}
