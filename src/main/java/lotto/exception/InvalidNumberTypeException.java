package lotto.exception;

import static lotto.domain.constant.StringConstant.LOTTO_NUM_TYPE_ERROR;

public class InvalidNumberTypeException extends IllegalArgumentException {
    public InvalidNumberTypeException() { super(LOTTO_NUM_TYPE_ERROR); }
}
