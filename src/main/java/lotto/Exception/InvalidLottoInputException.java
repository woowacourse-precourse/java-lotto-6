package lotto.Exception;

public class InvalidLottoInputException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호의 입력 형식이 맞지 않습니다.";

    public InvalidLottoInputException(){
        super(ERROR_MESSAGE);
    }
}
