package lotto.config;

public class MoneyException extends IllegalArgumentException{
    public static final String ERROR_MESSAGE = "[ERROR] 1,000원 단위의 숫자를 입력해주세요.";
    public MoneyException(int money){
        super(String.format(ERROR_MESSAGE));
    }
}
