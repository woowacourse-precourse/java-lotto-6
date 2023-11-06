package lotto.Exception;

public class InvalidRangeLottoNumberException extends IllegalArgumentException{
    private static  final String ERROR_MESSAGE = "[Error] 로또 숫자의 범위는 1이상 46이하여야합니다.";

    public InvalidRangeLottoNumberException(){
        super(ERROR_MESSAGE);
    }
}
