package lotto.exception.money;

public class InvalidNumberFormatException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요. : %s";

    public InvalidNumberFormatException(String input){
        super(String.format(ERROR_MESSAGE,input));
    }
}