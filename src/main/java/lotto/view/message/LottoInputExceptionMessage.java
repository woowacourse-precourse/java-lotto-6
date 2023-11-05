package lotto.view.message;

import lotto.view.constant.OutputConstant;

public enum LottoInputExceptionMessage {
    MONEY_TO_BUY_LOTTO_NOT_NUMERIC_TYPE(OutputConstant.ERROR_WARNING + "구입금액은 숫자 형식의 입력이어야 합니다." + OutputConstant.NEW_LINE);

    private final String message;
    LottoInputExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}