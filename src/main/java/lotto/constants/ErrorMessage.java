package lotto.constants;

public enum ErrorMessage {
    NULL_ERROR("[ERROR] 해당 입력이 NULL입니다."),
    BLANK_ERROR("[ERROR] 해당 입력이 공백입니다."),
    CONTAIN_BLANK_ERROR("[ERROR] 해당 입력에 공백이 포함되어 있습니다."),
    NOT_NUMBER_ERROR("[ERROR] 해당 입력은 숫자가 아닙니다."),
    NOT_ONE_TO_FORTYFIVE_ERROR("[ERROR] 해당 입력은 1 ~ 45까지의 범위를 벗어나는 숫자입니다."),
    NOT_DIVISIBLE_1000_ERROR("[ERROR] 해당 입력은 1000으로 나누어 떨어지지 않습니다."),
    UNDER_LOTTO_PRICE_ERROR("[ERROR] 최소 구입 금액은 1000원 입니다."),
    NOT_SIX_NUMBER_ERROR("[ERROR] 해당 입력은 6개의 숫자가 아닙니다."),
    DUPLICATE_NUMBER_ERROR("[ERROR] 중복된 숫자가 있습니다.");


    private final String error;

    ErrorMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
