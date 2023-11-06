package lotto.constant;

public class ExceptionMessage {

    private final static String ERROR = "[ERROR]";
    public final static String REQUIRE_INTEGER = String.format("%s 구입 금액은 9,223,372,036,854,775,807 이하의 정수여야 합니다.",
            ERROR);
    public final static String REQUIRE_POSITIVE_INTEGER = String.format("%s 구입 금액은 양의 정수여야 합니다.", ERROR);
    public final static String REQUIRE_MULTIPLE_OF_LOTTO_PRICE = String.format("%s 구입 금액은 %s으로 나누어 떨어져야 합니다.", ERROR,
            Number.LOTTO_PRICE);
    public static final String REQUIRE_NONEMPTY_INPUT = String.format("%s 값을 입력해주세요.", ERROR);
    public static final String REQUIRE_FIVE_COMMAS = String.format("%s \",\" 개수는 %s개여야 합니다.", ERROR,
            Number.LOTTO_NUM_COUNT - 1);
    //    public static final String REQUIRE_NOT_CONTINUOUSLY_COMMA = String.format("%s \",\"가 연속되지 않게 입력해야 합니다.", ERROR);
    public static final String REQUIRE_SIX_NUMBERS = String.format("[ERROR] 숫자 개수는 %s개여야 합니다.", Number.LOTTO_NUM_COUNT);
    public static final String REQUIRE_RIGHT_RANGE_NUMBER = String.format("%s 1~45 사이의 값을 입력해야 합니다.", ERROR);
    public static final String REQUIRE_UNIQUE_NUMBER = String.format("%s 중복되지 않은 값을 입력해야 합니다.", ERROR);
    public static final String REQUIRE_DIFFERENT_NUMBER_WITH_WINNING_NUMBERS = String.format(
            "%s 당첨번호와 중복되지 않은 값을 입력해주세요.", ERROR);
}
