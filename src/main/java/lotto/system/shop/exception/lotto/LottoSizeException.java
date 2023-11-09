package lotto.system.shop.exception.lotto;

public class LottoSizeException extends IllegalArgumentException {

    private static final String LOTTO_SIZE_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";

    public LottoSizeException() {
        super(LOTTO_SIZE_MESSAGE);
    }
}
