package view;

public class Messages {
    public static final String ERROR_HEADER = "[ERROR] ";
    public static final String ERROR_LOTTO_NUMBER_OUT_OF_BOUNDARY = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_NOT_DIVIDED_BY_1000 = "1000으로 나누어 떨어지는 수가 아닙니다.";
    public static final String ERR0R_MAXIMUM_PURCHASE = "1인당 최대 10만원까지 구입할 수 있습니다.";
    public static final String ERROR_MINIMUM_PURCHASE = "1인당 최소 1000원 이상 구입해야 합니다.";
    public static final String ERROR_DUPLICATE_NUMBERS = "중복된 숫자가 없어야 합니다.";
    public static final String ERROR_NOT_DIGIT = "숫자만 입력되어야 합니다.";
    public static final String ERROR_BONUS_NUMBER = "보너스 번호는 당첨 번호와 중복되면 안됩니다.";

    public static String sizeError(int size) {
        return String.format(ERROR_HEADER.concat("%d개의 숫자가 입력되어야 합니다."), size);
    }
}
