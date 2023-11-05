package lotto.common;

public enum ErrorMessage {

    ERROR_NUMBER_RANGE(
            "[ERROR] 로또 번호는 " + Constant.LOTTO_NUMBER_MIN.getIntValue() + "부터 " + Constant.LOTTO_NUMBER_MAX.getIntValue() + " 사이의 숫자여야 합니다."),
    ERROR_LOTTO_NUMBERS_LENGTH("[ERROR] 로또 번호는 " + Constant.LOTTO_NUMBERS_MAX_LENGTH.getIntValue() + "자리 숫자여야 합니다."),
    ERROR_LOTTO_NUMBERS_DUPLICATE("[ERROR] 로또 번호는 중복이 불가능합니다."),
    ERROR_LOTTO_NUMBERS_NULL("[ERROR] 로또 번호는 필수 입력값 입니다."),
    ERROR_LOTTO_NUMBERS_CONTAINS_BLANK("[ERROR] 로또 번호는 공백을 포함할 수 없습니다."),
    ERROR_LOTTO_NUMBERS_ENDS_WITH_COMMA("[ERROR] 맨 끝에 쉼표(,)가 포함되어 있습니다."),
    ERROR_LOTTO_ONE_TICKET_PRICE("[ERROR] 티켓 1장은 1000원입니다. 올바른 입력이 아닙니다."),
    ERROR_LOTTO_MIN_TICKET_PRICE("[ERROR] 최소 티켓 가격보다 적게 입력하였습니다."),
    ERROR_LOTTO_CONTAINS_BONUS_NUMBER("[ERROR] 잘못된 보너스 번호입니다. 이미 당첨 번호에 포함된 번호입니다."),
    ERROR_LOTTO_IS_NOT_ONE_BONUS_NUMBER("[ERROR] 잘못된 보너스 번호입니다. 1개만 입력 가능합니다."),
    ERROR_LOTTO_BONUS_NUMBER_NULL("[ERROR] 보너스 번호는 필수 입력값 입니다."),
    ERROR_LOTTO_BONUS_NUMBER_CONTAINS_BLANK("[ERROR] 보너스 번호는 공백을 포함할 수 없습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get(String... args) {
        return String.format(message, (Object) args);
    }
}
