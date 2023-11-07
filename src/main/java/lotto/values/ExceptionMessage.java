package lotto.values;

import static lotto.values.LottoInformation.MAX_VALUE;

public enum ExceptionMessage {
    NOT_IN_NUMBER_RANGE("1번부터 45번까지만 입력할 수 있습니다."),
    NOT_LOTTO_TOTAL_NUMBER("로또는 6개의 숫자를 뽑아야합니다."),
    NOT_WORK_LOTTO_GENERATOR("로또 발행기가 작동하지 않습니다. 다시 발행하겠습니다."),
    ONLY_ONE_FOR_BONUS_NUMBER("보너스 번호는 하나만 입력할 수 있습니다."),
    NOT_CORRECT_FORM("입력 양식에 맞지 않습니다."),
    NOT_NULL("입력값이 없습니다."),
    NOT_NUMBER("숫자만 입력할 수 있습니다."),
    CAN_NOT_PURCHASE("1000원 단위로만 구매할 수 있습니다."),
    TOO_MUCH_MONEY("로또는 최대 "+MAX_VALUE.getValue()+"원까지 구매할 수 있습니다."),
    ONLY_NUMBER("^[0-9]*$"),
    ERROR("[ERROR] ");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
