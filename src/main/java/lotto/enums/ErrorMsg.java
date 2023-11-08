package lotto.enums;

public enum ErrorMsg {
    ERROR("[ERROR]"),
    INVALID_NO_INPUT("입력값이 없습니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 숫자만 입력 가능합니다."),
    INVALID_BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_BONUS_NUMBER_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또(당첨) 번호는 6개만 입력 가능합니다."),
    INVALID_LOTTO_NUMBER_DUPLICATE("로또(당첨) 번호는 중복될 수 없습니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또(당첨) 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_PURCHASE_AMOUNT("구입 금액은 숫자만 입력 가능합니다."),
    INVALID_PURCHASE_AMOUNT_RANGE("구입 금액은 1000원 이상이어야 합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("구입 금액은 1000원 단위로 입력 가능합니다."),
    INVALID_WINNING_NUMBER("당첨 번호는 ,로 구분된 숫자만 입력 가능합니다."),
    ;

    private final String message;

    ErrorMsg(String message) {
        this.message = message;
    }

    public String getErrMsg() {
        return ERROR.message + " " + message;
    }
}
