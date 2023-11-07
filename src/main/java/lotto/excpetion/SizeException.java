package lotto.excpetion;

import static lotto.excpetion.constant.ExceptionMessage.OUT_OF_SIZE;

public class SizeException extends IllegalArgumentException{
    public SizeException() {
        super(OUT_OF_SIZE.getMessage());
    }
}
