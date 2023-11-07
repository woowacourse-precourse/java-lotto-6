package lotto.Enum;

import static lotto.Enum.Number.SIX;
import static lotto.Enum.Number.FORTY_FIVE;
import static lotto.Enum.Number.ONE;
import static lotto.Enum.Number.THOUSAND;

public enum ErrorMessage {

    LENGTH_ERROR("입력 개수는 "+ SIX.getNumber()+"개여야 합니다."),
    NUMBER_NOT_IN_RANGE_ERROR("로또 번호는 "+ ONE.getNumber()+"부터 "+ FORTY_FIVE.getNumber()+" 사이의 숫자여야 합니다."),
    DUPLICATED_ERROR("중복되지 않은 숫자여야 합니다."),
    NUMBER_NOT_DIVIDE_BY_THOUSAND_ERROR(THOUSAND.getNumber()+"원 단위로 입력해야 합니다."),
    NOT_NUMBER_ERROR("입력값은 숫자여야 합니다."),
    INDEX_OUT_OF_RANGE_ERROR("Invalid index : IndexOutOfBoundsException");

    private final String message;

    ErrorMessage(String message){
        String error = "[ERROR] ";
        this.message = error + message;
    }

    public String getMessage() {
        return message;
    }
}