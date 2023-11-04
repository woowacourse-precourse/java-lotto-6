package lotto;

public class StringResourceProvider {

    // TEXT
    public static final String INPUT_PURCHASE_AMOUNT_TEXT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS_TEXT = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_TEXT = "보너스 번호를 입력해 주세요.";
    public static final String OUTPUT_LOTTERY_RESULT = "당첨 통계";

    // ERROR
    public static final String ERROR_MESSAGE_TAG = "[ERROR]";
    public static final String PURCHASE_AMOUNT_CANNOT_CONVERT_TO_LONG_TEXT = "입력값을 Long 타입으로 변환할 수 없습니다.";
    public static final String PURCHASE_AMOUNT_CANNOT_BE_NEGATIVE_LONG_TEXT = "구입금액은 양수야 합니다.";
    public static final String PURCHASE_AMOUNT_MUST_BE_DIVIDE_BY_LOTTERY_PRICE_TEXT = "구입금액은 1000으로 나눌 수 있어야 합니다.";
}
