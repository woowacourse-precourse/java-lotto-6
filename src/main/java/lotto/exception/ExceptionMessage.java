package lotto.exception;

public class ExceptionMessage {

    private static final String PREFIX = "[ERROR]";
    private static final String SPACE = " ";
    public static final String MESSAGE_IS_NUMERIC = PREFIX + SPACE + "숫자만 입력 가능합니다.";
    public static final String MESSAGE_COMMA_NUMERIC = PREFIX + SPACE + "숫자와 숫자 구분으로 쉼표만 입력 가능합니다.";
    public static final String MESSAGE_THOUSAND_UNIT = PREFIX + SPACE + "1000원 단위만 입력 가능합니다.";
    public static final String MESSAGE_LIMIT_MONEY = PREFIX + SPACE + "1,000,000 만원 까지 입력 가능합니다.";
    public static final String MESSAGE_RANGE_NUMBER = PREFIX + SPACE + "1 ~ 45 까지 입력 가능합니다.";
    public static final String MESSAGE_LIMIT_SIZE = PREFIX + SPACE + "로또 번호는 6개까지 입력 가능합니다.";
    public static final String MESSAGE_DUPLICATE_NUMBER = PREFIX + SPACE + "로또 번호는 6개까지 입력 가능합니다.";

}
