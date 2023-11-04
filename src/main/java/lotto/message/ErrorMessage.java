package lotto.message;

public enum ErrorMessage {
    NOT_IN_NUMBER_RANGE("1번부터 45번까지만 입력할 수 있습니다."),
    NOT_LOTTO_TOTAL_NUMBER("로또는 6개의 숫자를 뽑아야합니다."),
    ONLY_ONE_FOR_BONUS_NUMBER("보너스 번호는 하나만 입력할 수 있습니다."),
    NOT_CORRECT_FORM("입력 양식에 맞지 않습니다."),
    NOT_NUMBER("숫자만 입력할 수 있습니다."),
    CAN_NOT_PURCHASE("1000원 단위로만 구매할 수 있습니다."),
    TOO_MUCH_MONEY("로또는 최대 %d장까지만 구매할 수 있습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
