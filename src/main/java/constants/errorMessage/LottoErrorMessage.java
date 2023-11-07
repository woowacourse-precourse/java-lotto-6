package constants.errorMessage;

import constants.Constants;

public enum LottoErrorMessage {
    INVALID_LENGTH("로또는 "+ Constants.LOTTO_LENGTH +"개의 숫자로 구성되어야 합니다."),
    DUPLICATION_OCCUR("로또에는 중복되는 숫자가 있을 수 없습니다."),
    OUT_OF_RANGE("로또 번호의 범위는 "+Constants.LOTTO_RANGE_START+"부터 "
            + Constants.LOTTO_RANGE_END + "까지 입니다.");

    private String message;

    LottoErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}