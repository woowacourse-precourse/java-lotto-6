package lotto.exception;

import lotto.constant.Error;

public class InputException extends IllegalArgumentException{

    public InputException(Error error) {
        super(error.getMessage());
        System.out.println(error.getMessage());
    }

}