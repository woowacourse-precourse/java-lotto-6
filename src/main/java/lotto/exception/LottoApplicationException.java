package lotto.exception;

import java.util.NoSuchElementException;

public class LottoApplicationException extends IllegalArgumentException {
    public LottoApplicationException(String message) {
        super("[ERROR] " + message);
    }


}
