package lotto.exception;

public class DuplicatedLottoNumberException extends IllegalArgumentException {
    private static final String DUPLICATED_LOTTO_NUMBER = "[ERROR] 로또번호는 중복되어서 안됩니다.";

    public DuplicatedLottoNumberException() {
        super(DUPLICATED_LOTTO_NUMBER);
    }
}
