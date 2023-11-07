package lotto.message;

public class ErrorMessage {
    public static final String TEMPLATE = "[ERROR] %s";
    public static final String NOT_INTEGER = String.format(TEMPLATE, "정수를 입력해주세요.");
    public static final String INVALID_AMOUNT = String.format(TEMPLATE, "입력한 가격은 1000원 단위여야 합니다.");
    public static final String INVALID_INPUT_LOTTO_NUMBER_COUNT = String.format(TEMPLATE, "당첨 번호는 6개여야 합니다.");
}
