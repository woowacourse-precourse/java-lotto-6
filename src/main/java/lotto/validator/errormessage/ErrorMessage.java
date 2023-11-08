package lotto.validator.errormessage;

public enum ErrorMessage {
    INVALID_NUMBER("[ERROR] 숫자를 입력해주세요."),
    EMPTY_INPUT("[ERROR] 값을 입력해주세요."),
    NUMBER_OUT_OF_RANGE("[ERROR] 숫자의 범위는 1~45 입니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스번호는 당첨번호와 중복될 수 없습니다"),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 중복된 로또번호가 있습니다." ),
    LOTTO_NUMBER_OUT_OF_SIZE("[ERROR] 로또번호는 6자리 입력가능합니다."),
    SMALL_THAN_THOUSAND("[ERROR] 로또의 한장 가격은 1000원 입니다."),
    INDIVIDABLE_THOUSAND("[ERROR] 로또의 한장 가격은 1000원 입니다. 1000원 단위로 입력하십시오."),
    INCORRECT_NUMERICAL_INPUT("[ERROR] 입력값으로 올바른 숫자를 입력하십시오.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
