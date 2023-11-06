package lotto.view.message;

import lotto.view.constant.OutputConstant;

public enum LottoInputExceptionMessage {
    INPUT_IS_EMPTY(OutputConstant.ERROR_WARNING + "비어있는 입력값 입니다." + OutputConstant.NEW_LINE),
    USER_MONEY_IS_NOT_NUMERIC_TYPE(OutputConstant.ERROR_WARNING + "구입금액은 숫자 형식의 입력이어야 합니다." + OutputConstant.NEW_LINE),
    USER_MONEY_IS_NOT_DIVISIBLE_WITH_LOTTO_PRICE(OutputConstant.ERROR_WARNING + "구입금액이 로또 금액으로 나누어 떨어지지 않습니다." + OutputConstant.NEW_LINE),
    WINNING_LOTTO_NUMBERS_DOES_NOT_CONTAIN_DELIMITER(OutputConstant.ERROR_WARNING + "당첨번호는 쉼표(,)를 기준으로 입력해주셔야 합니다." + OutputConstant.NEW_LINE),
    WINNING_LOTTO_NUMBERS_DOES_NOT_CONTAIN_SIX_NUMBERS(OutputConstant.ERROR_WARNING + "입력된 당첨번호가 6개가 아닙니다." + OutputConstant.NEW_LINE),
    WINNING_LOTTO_NUMBERS_CONTAINS_EMPTY_NUMBER(OutputConstant.ERROR_WARNING + "입력된 당첨번호 중 비어있는 값이 존재합니다." + OutputConstant.NEW_LINE);

    private final String message;
    LottoInputExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}