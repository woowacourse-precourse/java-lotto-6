package lotto.constant;

public class ExceptionMessage {
    private final static String ERROR = "[ERROR]";
    public final static String REQUIRE_INTEGER = String.format("%s 구입 금액은 정수형이여야 합니다.", ERROR);
    public final static String REQUIRE_POSITIVE_INTEGER =  String.format("%s 구입 금액은 양의 정수여야 합니다.", ERROR);
    public final static String REQUIRE_MULTIPLE_OF_LOTTO_PRICE =  String.format("%s 구입 금액은 %s으로 나누어 떨어져야 합니다.", ERROR, Number.LOTTO_PRICE);
}
