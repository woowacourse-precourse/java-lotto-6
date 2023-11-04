package lotto.exception;

public enum ErrorMessage {

    ERROR_NUMBER_RANGE(
            "[ERROR] 로또 번호는 " + Constant.LOTTO_NUMBER_MIN.getIntValue() + "부터 " + Constant.LOTTO_NUMBER_MAX.getIntValue() + " 사이의 숫자여야 합니다."),

    ERROR_LOTTO_NUMBERS_LENGTH("[ERROR] 로또 번호는 " + Constant.LOTTO_NUMBERS_MAX_LENGTH.getIntValue() + "자리 숫자여야 합니다."),
    ERROR_LOTTO_NUMBERS_DUPLICATE("[ERROR] 로또 번호는 중복이 불가능합니다."),
    ERROR_LOTTO_NUMBERS_NULL("[ERROR] 로또 번호를 입력하지 않았습니다."),
    ERROR_LOTTO_NUMBERS_CONTAINS_BLANK("[ERROR] 공백을 포함하고 있습니다."),
    ERROR_LOTTO_NUMBERS_ENDS_WITH_COMMA("[ERROR] 맨 끝에 쉼표(,)가 포함되어 있습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get(String... args) {
        return String.format(message, (Object) args);
    }
}
