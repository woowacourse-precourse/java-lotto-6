package lotto.exception;

public class WrongLottoInputFormatException extends IllegalArgumentException {


    public static final String ERROR_MESSAGE = "[ERROR] 당첨 로또는 쉼표로 구분된 6개의 숫자를 입력해야 합니다.";

    public WrongLottoInputFormatException() {

        super(ERROR_MESSAGE);
    }
}
