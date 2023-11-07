package lotto.exception;

// 예외가 발생하는 경우, 오류와 함께 사용자에게 반환할 메세지
public enum GameExceptionMessage {
    INPUT_VALUE_IS_NOT_NUMBER("유효하지 않은 값을 입력하셨습니다. 숫자가 맞는지 확인해주세요."),
    INPUT_VALUE_NOT_VALID_FORMAT("로또를 구매할 수 있는 금액은 1,000 단위로 입력해야합니다. 다시 입력해주세요."),
    INPUT_VALUE_NOT_VALID_LENGTH("로또 번호는 6개의 수로 이루어져야합니다. 다시 한 번 확인해주세요."),
    INPUT_VALUE_MUST_DISTINCT("로또 번호는 중복되어서는 안됩니다. 다시 한 번 확인해주세요."),
    INPUT_VALUE_NOT_VALID_RANGE("1이상, 45이하의 값을 입력해주세요."),
    RECURSION_EXCEED_THE_LIMIT("번 연속으로 유효하지 않은 값을 입력하셨습니다. 다음에 다시 시도해주세요.")
    ;
    private final String message;

    GameExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
