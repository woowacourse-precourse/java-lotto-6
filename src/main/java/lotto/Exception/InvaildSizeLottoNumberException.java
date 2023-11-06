package lotto.Exception;

public class InvaildSizeLottoNumberException extends IllegalArgumentException{
    private static  final String ERROR_MESSAGE = "[Error] 로또 번호의 개수는 6개이어야 합니다.";

    public InvaildSizeLottoNumberException(){
        super(ERROR_MESSAGE);
    }
}
