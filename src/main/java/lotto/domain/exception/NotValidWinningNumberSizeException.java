package lotto.domain.exception;

public class NotValidWinningNumberSizeException extends IllegalArgumentException {

    public NotValidWinningNumberSizeException() {
        super("[ERROR] 당첨 번호는 6개를 입력해야 합니다.\n");
    }
}
