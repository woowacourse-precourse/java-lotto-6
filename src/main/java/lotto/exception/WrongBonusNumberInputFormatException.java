package lotto.exception;

public class WrongBonusNumberInputFormatException  extends IllegalArgumentException {


    public static final String ERROR_MESSAGE = "[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.";

    public WrongBonusNumberInputFormatException() {

        super(ERROR_MESSAGE);
    }
}
