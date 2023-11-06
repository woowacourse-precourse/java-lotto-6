package lotto.execption;

public class LottoNumberSizeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 6개 입력해야 합니다.";
    public LottoNumberSizeException() {
        super(ERROR_MESSAGE);
    }
}
