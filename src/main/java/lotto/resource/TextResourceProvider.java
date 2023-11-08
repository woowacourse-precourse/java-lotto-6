package lotto.resource;

public class TextResourceProvider {

    // ERROR
    public static final String ERROR_MESSAGE_TAG = "[ERROR]";
    public static final String PURCHASE_AMOUNT_CANNOT_CONVERT_TO_LONG_TEXT = "입력값을 Long 타입으로 변환할 수 없습니다.";
    public static final String PURCHASE_AMOUNT_CANNOT_BE_NEGATIVE_LONG_TEXT = "구입금액은 양수야 합니다.";
    public static final String PURCHASE_AMOUNT_MUST_BE_DIVIDE_BY_LOTTERY_PRICE_TEXT = "구입금액은 1000으로 나눌 수 있어야 합니다.";
    public static final String WINNING_NUMBERS_MUST_BE_SEPARATED_BY_SIX_INTEGER_WITH_DELIMITER_TEXT = "당첨번호는 ','로 구분된 6개의 Integer 타입의 숫자여야 합니다";
    public static final String WINNING_NUMBERS_MUST_BE_BETWEEN_1_AND_45_TEXT = "당첨번호는 1과 45 사이의 숫자로 이루어져야 합니다";
    public static final String WINNING_NUMBERS_SHOULD_BE_6_UNIQUE_NUMBERS_TEXT = "당첨번호는 6개의 중복되지 않는 숫자여야 합니다";
    public static final String BONUS_NUMBER_CANNOT_CONVERT_TO_INTEGER_TEXT = "보너스번호는 Integer 타입의 숫자야 합니다";
    public static final String BONUS_NUMBER_MUST_BE_BETWEEN_1_AND_45_TEXT = "보너스번호는 1과 45 사이의 숫자여야 합니다";
    public static final String BONUS_NUMBER_SHOULD_NOT_IN_WINNING_NUMBERS_TEXT = "보너스번호는 당첨번호에 없는 숫자여야 합니다";

    public static final TextFormat ERROR_TEXT_FORMAT = new TextFormat("[ERROR] %s");

    // TEXT
    public static final String INPUT_PURCHASE_AMOUNT_TEXT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS_TEXT = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_DELIMITER = ",";
    public static final String INPUT_BONUS_NUMBER_TEXT = "보너스 번호를 입력해 주세요.";
    public static final String OUTPUT_LOTTERY_RESULT_TEXT = "당첨 통계";
    public static final String OUTPUT_LOTTERY_RESULT_HEADER_LINE_TEXT = "---";
    public static final TextFormat QUANTITY_OUTPUT_TEXT_FORMAT = new TextFormat("%s개를 구매했습니다.");
    public static final TextFormat LOTTO_NUMBERS_TEXT_FORMAT = new TextFormat("[%s, %s, %s, %s, %s, %s]");

    public static final TextFormat LOTTERY_RANKING_RESULT_FORMAT = new TextFormat("%s - %s개");
    public static final TextFormat LOTTERY_RANKING_RESULT_DEFAULT_HEADER_FORMAT = new TextFormat("%s개 일치 (%s원)");
    public static final TextFormat LOTTERY_RANKING_RESULT_SECOND_HEADER_FORMAT = new TextFormat(
            "%s개 일치, 보너스 볼 일치 (%s원)");
    public static final TextFormat LOTTERY_EARNING_RATE_RESULT_TEXT = new TextFormat("총 수익률은 %s%입니다.");
}
