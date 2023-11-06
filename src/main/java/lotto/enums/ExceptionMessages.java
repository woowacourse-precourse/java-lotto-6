package lotto.enums;

public enum ExceptionMessages {

    PURCHASE_MONEY_IS_NOT_DIVIDENED_BY_ONE_THOUSAND("구입 금액은 1,000 단위여야합니다."),
    PURCHASE_MONEY_IS_EMPTY_VALUE("아무런 값도 입력되지 않았습니다. 1,000단위의 숫자값을 입력해야합니다."),
    PURCHASE_MONEY_IS_NOT_NUMBER("문자가 입력되었습니다. 1,000단위의 숫자값을 입력해야 합니다."),
    PURCHASE_MONEY_IS_NOT_OVER_ONE_THOUSAND("1,000원보다 작은 금액이 입력되었습니다. 1,000단위의 숫자값을 입력해야합니다."),
    LOTTO_SIZE_IS_OVER_SIX("로또 번호의 갯수가 6개보다 많이 입력되었습니다. 6자리로 입력해야합니다."),
    LOTTO_IS_DUPLICATED("로또 번호가 중복되었습니다. 중복되지 않은 번호를 입력해야 합니다."),
    LOTTO_IS_NOT_BETWEEN_ONE_AND_FORTYFIVE("로또 번호의 범위가 1~45가 아닙니다. 1~45사이의 번호를 입력해야 합니다."),
    LOTTO_IS_NOT_NUMER("로또 번호가 문자로 입력되었습니다. 로또 번호를 1~45사이의 숫자를 입력해야 합니다."),
    LOTTO_IS_EMPTY("로또 번호가 입력되지 않았습니다. 로또 번호를 1~45 사이의 숫자를 입력해야 합니다."),
    BONUS_NUMBER_IS_NOT_BETWEEN_ONE_AND_FORTYFIVE("보너스 번호의 범위가 1~45가 아닙니다. 1~45 사이의 번호를 입력해야합니다."),
    BONUS_NUMBER_IS_NOT_NUMBER("보너스 번호가 숫자가 아닙니다. 보너스 번호를 1~45사이의 숫자를 입력해야합니다."),
    BONUS_NUMBER_IS_EMPTY("보너스 번호가 입력되지 않았습니다. 보너스 번호를 1~45사이의 숫자를 입력해야합니다."),
    BONUS_NUMBER_IS_DUPLICATED_WINNING_NUMBER("보너스 번호가 당첨번호와 중복됩니다. 중복되지 않는 숫자를 입려해야합니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String message;


    ExceptionMessages(String message){
        this.message = ERROR_TAG + message;
    }

    public String getMessage(){
        return message;
    }

    public void throwException(){
        throw new IllegalArgumentException(message);
    }
}
