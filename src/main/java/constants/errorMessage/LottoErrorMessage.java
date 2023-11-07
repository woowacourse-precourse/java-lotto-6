package constants.errorMessage;

import constants.Constants;

public enum LottoErrorMessage {
    INVALID_LENGTH("로또 번호의 개수가 올바르지 않습니다."),
    DUPLICATION_OCCUR("로또 번호는 중복된 숫자를 포함할 수 없습니다."),
    OUT_OF_RANGE("로또 번호는 지정된 범위 내에서 선택해야 합니다.");

    private String message;

    LottoErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}