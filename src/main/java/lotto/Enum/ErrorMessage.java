package lotto.Enum;

import static lotto.Enum.Number.SIX;
import static lotto.Enum.Number.MAX_NUMBER;
import static lotto.Enum.Number.MIN_NUMBER;
import static lotto.Enum.Number.UNIT;

public enum ErrorMessage {

    LENGHT_ERROR("입력 개수는 "+ SIX.getNumber()+"개여야 합니다."),
    NUMBER_RANGE_ERROR("로또 번호는 "+MIN_NUMBER.getNumber()+"부터 "+MAX_NUMBER.getNumber()+" 사이의 숫자여야 합니다."),
    DUPLICATED_ERROR("중복되지 않은 숫자여야 합니다."),
    UNIT_ERROR(UNIT.getNumber()+"원 단위로 입력해야 합니다."),
    NOT_NUMBER_ERROR("입력값은 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message){
        String error = "[ERROR] ";
        this.message = error + message;
    }

    public String getMessage() {
        return message;
    }
}