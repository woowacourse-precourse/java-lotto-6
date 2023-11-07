package lotto.exception;

import lotto.constant.Error;

public class LottoException extends IllegalArgumentException{

    public LottoException(Error error) {
        super(error.getMessage());
        System.out.println(error.getMessage());
    }

}
