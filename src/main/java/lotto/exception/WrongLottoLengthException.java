package lotto.exception;

import static lotto.constants.LottoConstants.LENGTH;

public class WrongLottoLengthException extends IllegalArgumentException{



    public static final String ERROR_MESSAGE = String.format("[ERROR] 로또의 길이는 %d이여야 합니다.", LENGTH);

    public WrongLottoLengthException() {
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);
    }
}
