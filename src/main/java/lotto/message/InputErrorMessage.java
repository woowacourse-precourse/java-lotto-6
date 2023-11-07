package lotto.message;

public final class InputErrorMessage {
    public static String INVALID_INPUT_FORMAT = "[ERROR] 형식에 적합하지 않는 입력 형식입니다. %s만 입력해 주세요";
    public static String INVALID_INPUT_UNIT = "[ERROR] 단위를 잘못 입력하셨습니다.";
    public static String INVALID_INPUT_NEGATIVE = "[ERROR] 0 보다 큰 수를 입력해 주세요.";
    public static String INVALID_INPUT_MAXIMUM = "[ERROR] 정수의 최대값 보다 큰 수는 입력 할 수 없습니다.";
    public static String INVALID_INPUT_LOTTO_NUMBERS_COUNT = "[ERROR] 당첨 번호는 6개여야 합니다.";
    public static String INVALID_INPUT_LOTTO_DUPLICATE_NUMBERS = "[ERROR] 당첨 번호는 중복이 있으며 안됩니다.";
    public static String INVALID_INPUT_LOTTO_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static String INVALID_INPUT_BONUS_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복이 되면 안됩니다.";
}
