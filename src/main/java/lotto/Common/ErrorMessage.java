package lotto.Common;

public enum ErrorMessage {
    //Model

    NUMBER_NOT_SORTED("수가 오름차순 정렬이 아닙니다."),
    NUMBER_OUT_OF_RANGE("입력 숫자 범위가 1~9여야 합니다."),
    NUMBER_COUNT_INVALID("로또가 6자리가 아닙니다."),
    NUMBER_DUPLICATE("로또 번호에 중복이 있습니다."),
    LOTTO_SET_NULL("로또 묶음이 null 값 입니다."),
    LOTTO_SET_EMPTY("로또 묶음이 비어 있습니다."),
    PURCHASE_AMOUNT_IS_POSITIVE_INTEGER("구입 금액은 양수 입니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_THOUSAND("구입 금액은 1000의 자리로 나눠 떨어져야 합니다."),
    WINNING_NUMBER_COUNT_INVALID("정답 갯수가 6자리가 아닙니다."),
    WINNING_NUMBER_DUPLICATE("정답 번호에 중복이 있습니다."),


    //InputView
    INPUT_EMPTY("입력이 비었습니다."),
    INPUT_NOT_INTEGER("입력이 정수가 아닙니다."),
    INPUT_DUPLICATE_WITH_WINNING("입력하신 번호는 당첨 번호와 중복됩니다."),
    INPUT_WRONG_SEPARATOR("정수 형태의 입력이 쉼표로 구분 되어야 합니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        String errorMessage = "[ERROR] ";
        return errorMessage + message;
    }
}
