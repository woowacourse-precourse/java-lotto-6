package lotto.system;

public class ErrorMessage {
    public static final String NOT_DIVISIBLE =
            "[ERROR] 금액이 " + Constants.MONEY_UNIT.getConstants() + "으로 떨어지지 않는 값을 입력했습니다.";
    public static final String NOT_NUMERIC = "[ERROR] 숫자가 아닌 값을 입력 했습니다.";
    public static final String AMOUNT_OUT_OF_RANGE = "[ERROR] 입력 범위가 넘어간 값을 입력 했습니다.";
    public static final String NOT_POSITIVE = "[ERROR] 음수인 값을 입력 했습니다.";
    public static final String LOTTO_NUMBER_OUT_OF_RANGE =
            "[ERROR] 입력한 로또의 값이 "
                    + Constants.START_NUMBER.getConstants()
                    + "이상 " + Constants.END_NUMBER.getConstants()
                    + "이하가 아닌 값을 입력 했습니다.";
    public static final String EACH_NOT_NUMERIC = "[ERROR] 입력한 로또의 값들 중에 숫자가 아닌 값이 있습니다.";
    public static final String LOTTO_IS_OVER_SIZE =
            "[ERROR] 로또의 길이가 " + Constants.LOTTO_SIZE.getConstants() + " 이 아닙니다.";
    public static final String NUM_DUPLICATION = "[ERROR] 로또는 중복된 값이 들어 갈 수 없습니다.";
    public static final String ALREADY_EXIST = "[ERROR] 이미 당첨 번호에서 입력한 값입니다.";

    private ErrorMessage() {
    }

}
