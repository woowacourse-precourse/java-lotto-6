package lotto.message;

public enum ErrorMessage {
    LOTTO_NUMBERS_ARE_NOT_NUMERIC_MESSAGE("[ERROR] 입력된 로또 번호가 숫자가 아닙니다."),
    LOTTO_NUMBERS_ARE_NOT_IN_RANGE_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    LOTTO_NUMBERS_ARE_DUPLICATED_MESSAGE("[ERROR] 로또 번호에 중복된 로또 번호가 존재합니다."),

    LOTTO_NUMBERS_ARE_NOT_ENOUGH_MESSAGE("[ERROR] 로또 번호의 개수가 부족합니다."),

    BONUS_NUMBER_IS_NOT_NUMERIC_MESSAGE("[ERROR] 입력된 보너스 번호가 숫자가 아닙니다."),

    BONUS_NUMBER_NOT_IN_RANGE_MESSAGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),

    BONUS_NUMBER_IS_DUPLICATED_BY_LOTTO_NUMBER("[ERROR] 보너스 번호가 당첨번호와 중복됩니다."),

    PURCHASE_AMOUNT_IS_NOT_NUMERIC_MESSAGE("[ERROR] 입력된 보너스 번호가 숫자가 아닙니다."),


    PURCHASE_AMOUNT_IS_NOT_JUSTIFIED_MESSAGE("[ERROR] 구매 금액이 올바르지 않습니다.");

    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
