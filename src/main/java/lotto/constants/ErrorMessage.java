package lotto.constants;

public enum ErrorMessage {

    LABEL("[ERROR]"),
    NOT_DIVISIBLE_TICKET_PRICE(Lotto.COST.getValue() + "원 단위로만 입력 가능합니다."),
    OUT_OF_RANGE("1,000 ~ 2,147,483,000 사이의 값만 허용합니다."),
    INVALID_LOTTO_NUMBER_FORMAT("공백없이 콤마(,)를 기준으로 구분하여 숫자를 입력하세요."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    DUPLICATE_LOTTO_NUMBER("당첨 번호는 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public String getLabeledErrorMessage() {
        return LABEL + " " + message;
    }
}
