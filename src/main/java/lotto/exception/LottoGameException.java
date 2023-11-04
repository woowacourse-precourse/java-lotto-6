package lotto.exception;

import camp.nextstep.edu.missionutils.Console;

public class LottoGameException extends IllegalArgumentException{
    private LottoGameException(String message){
        super(message);
    }

    public static LottoGameException of(String message){
        Console.close();
        return new LottoGameException(message);
    }
}
