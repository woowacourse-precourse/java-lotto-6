package lotto.string;

public enum ErrorMessage {
    AMOUNT_NULL_ERROR_MESSAGE("[ERROR] 구입 금액이 빈칸이면 안됩니다."),
    AMOUNT_CHARACTER_ERROR_MESSAGE("[ERROR] 구입 금액은 숫자가 입력 되어야 합니다."),
    AMOUNT_UNIT_ERROR_MESSAGE("[ERROR] 구입 금액은 거스름 돈이 생기면 안됩니다."),
    WININGNUMBER_CHARACTER_ERROR_MESSAGE("[ERROR] 당첨 번호는 숫자가 입력 되어야 합니다."),
    WININGNUMBER_RANGE_ERROR_MESSAGE("[ERROR] 당첨 번호는 1~45의 숫자가 입력 되어야 합니다."),
    WININGNUMBER_NUMBERSIZE_ERROR_MESSAGE("[ERROR] 당첨 번호 6개를 입력해야 합니다."),
    WININGNUMBER_DOUBLECHECK_ERROR_MESSAGE("[ERROR] 당첨 번호는 중복되어선 안됩니다."),
    BONUSNUMBER_CHARACTER_ERROR_MESSAGE("[ERROR] 보너스 번호는 숫자 한개만 입력 되어야 합니다."),
    BONUSNUMBER_RANGE_ERROR_MESSAGE("[ERROR] 보너스 번호는 1~45의 숫자를 입력해야 합니다."),
    BONUSNUMBER_DOUBLECHECK_ERROR_MESSAGE("[ERROR] 보너스 번호가 입력된 당첨 번호와 중복되었습니다.")
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
