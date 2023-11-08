package lotto.exception;

import static lotto.exception.ExceptionMessage.OUT_OF_SIZE;

public class SizeException extends IllegalArgumentException{
    public SizeException() {
        super(OUT_OF_SIZE.getMessage());
    }
}
