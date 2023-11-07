package lotto.Enum;

import static lotto.Enum.Number.LOTTO_SIZE;
import static lotto.Enum.Number.MAX_LOTTO_NUMBER;
import static lotto.Enum.Number.MIN_LOTTO_NUMBER;
import static lotto.Enum.Number.THOUSAND;

public enum ErrorMessage {

    LENGTH_ERROR("입력 개수는 "+ LOTTO_SIZE.getNumber()+"개여야 합니다."),
    NUMBER_NOT_IN_RANGE_ERROR("로또 번호는 "+ MIN_LOTTO_NUMBER.getNumber()+"부터 "+ MAX_LOTTO_NUMBER.getNumber()+" 사이의 숫자여야 합니다."),
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