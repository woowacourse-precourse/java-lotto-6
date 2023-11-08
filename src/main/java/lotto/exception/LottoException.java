package lotto.exception;

import camp.nextstep.edu.missionutils.Console;

public class LottoException extends IllegalArgumentException {
    private LottoException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static LottoException of(ErrorMessage errorMessage) {
        Console.close();
        return new LottoException(errorMessage);
    }

}