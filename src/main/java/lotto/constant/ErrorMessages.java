package lotto.constant;

public enum ErrorMessages {

    NOT_NUMBER("입력한 구입 금액이 유효하지 않습니다. 정수만 입력 가능합니다."),
    NOT_THOUSAND("입력한 금액이 유효하지 않습니다. 1000원 단위로 입력 가능합니다."),
    NOT_ENOUGH_MONEY("입력한 금액이 유효하지 않습니다. 1000원 이상의 금액을 입력해주세요."),
    NOT_LOTTO_NUMBER("입력한 로또 번호가 유효하지 않습니다. 쉼표로 구분한 숫자만 입력 가능합니다."),
    NOT_SIX("입력한 로또 번호가 유효하지 않습니다. 6개의 숫자를 입력해주세요."),
    NOT_IN_RANGE("입력한 로또 번호가 유효하지 않습니다. 1부터 45까지의 숫자만 입력 가능합니다."),
    NOT_UNIQUE("입력한 로또 번호가 유효하지 않습니다. 중복되지 않은 숫자 6개를 입력해주세요.");

    private static final String ERROR_FORM = "[ERROR]";

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format("%s %s", ERROR_FORM, message);
    }
}
