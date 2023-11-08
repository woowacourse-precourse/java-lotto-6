package lotto.exception;

public enum ErrorType {

    AmountMinimumException("[ERROR] 로또 최소 구입 가능 금액은 1000원입니다."),
    AmountUnitException("[ERROR] 로또 금액은 1000원 단위입니다."),
    BonusNumberDuplicatedException("[ERROR] 당첨 번호에 보너스 번호와 중복된 숫자가 있습니다!"),
    InputMoneyNotDigitException("[ERROR] 금액은 숫자만 입력 가능합니다."),
    InputMoneyOverflowException("[ERROR] 입력한 금액이 유효한 숫자 범위를 벗어났습니다."),
    InvalidNumberSizeException("[ERROR] 로또 숫자는 6개입니다!"),
    InsideListDuplicatedException("[ERROR] 당첨 번호 내에 중복된 숫자가 있습니다!"),
    OverValueException("[ERROR] 로또 번호의 범위는 45입니다!"),

    ;

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
