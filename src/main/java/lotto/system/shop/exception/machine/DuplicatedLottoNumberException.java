package lotto.system.shop.exception.machine;

public class DuplicatedLottoNumberException extends IllegalArgumentException {

    private static final String DUPLICATED_LOTTO_NUMBER_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    public DuplicatedLottoNumberException() {
        super(DUPLICATED_LOTTO_NUMBER_MESSAGE);
    }
}
