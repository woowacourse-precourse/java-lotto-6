    package lotto.exception;

public class WinningLottoNumbersDuplicationException extends IllegalArgumentException{

    public static final String ERROR_MESSAGE = "[ERROR] 당첨 번호 간에 중복된 숫자가 있어선 안됩니다.";

    public WinningLottoNumbersDuplicationException() {
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);
    }
}
