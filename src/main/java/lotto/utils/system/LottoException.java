package lotto.utils.system;

public class LottoException extends RuntimeException {

    public LottoException() {

    }

    public LottoException(String msg) {
        super("[ERROR] "+msg);
    }
}
