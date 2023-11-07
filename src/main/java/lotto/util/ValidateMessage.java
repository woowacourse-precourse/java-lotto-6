package lotto.util;

public class ValidateMessage {
    public static final String INPUT_AMOUNT_TYPE = "^[0-9]+$";
    public static final String INPUT_LOTTO_TYPE = "^[0-9]+(,[0-9]+)*$";
    public static final String ERROR_NUMBER_MESSAGE = "[ERROR] 입력값은 숫자만 가능합니다.";
    public static final String ERROR_THOUSAND_MESSAGE = "[ERROR] 1000단위로만 입력이 가능합니다.";
    public static final String ERROR_ZERO_MESSAGE = "[ERROR] 입력값은 0 일수 없습니다.";
    public static final String ERROR_SIZE_MESSAGE = "[ERROR] 당첨 숫자 개수는 6개여야 합니다.";
    public static final String ERROR_UNIQUE_MESSAGE = "[ERROR] 중복된 당첨 숫자를 입력할 수 없습니다.";
    public static final String ERROR_COMMA_MESSAGE = "[ERROR] 구분자 쉼표 와 숫자만 입력이가능합니다.";
    public static final String ERROR_LOTTO_NUMBER_MESSAGE = "[ERROR] 1 ~ 45 숫자만 입력할 수 있습니다.";

}
