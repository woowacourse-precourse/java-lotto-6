package lotto.system.shop.exception.lotto;

public class DuplicateLottoNumberException extends IllegalArgumentException {

    private static final String DUPLICATE_LOTTO_NUMBER_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    public DuplicateLottoNumberException() {
        super(DUPLICATE_LOTTO_NUMBER_MESSAGE);
    }
}
