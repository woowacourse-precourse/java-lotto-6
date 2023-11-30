package lotto.utils.system;

public class LottoException extends IllegalArgumentException {

    public LottoException() {

    }

    public LottoException(String msg) {
        super("[ERROR] "+msg);
    }
}
