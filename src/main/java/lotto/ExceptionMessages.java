package lotto;

public enum ExceptionMessages {

    NOT_VALIDATED_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_VALIDATED_NUMBER_SIZE("로또 번호 6개를 입력해주세요."),
    NOT_VALIDATED_WINNING_NUMBER_SIZE("서로 다른 당첨 번호 6개를 입력해주세요."),
    NOT_VALIDATED_PURCHASE_AMOUNT("금액은 1,000원 단위로 입력해주세요."),
    DUPLICATE_NUMBER_INPUT("서로 다른 숫자를 입력해주세요."),
    NOT_VALIDATED_INPUT_TYPE("올바른 타입으로 입력해주세요."),
    BONUS_NUMBER_DUPLICATE("당첨 번호에 중복되는 숫자가 존재합니다.");

    private final String message;

    ExceptionMessages(String message) {

        this.message = message;
    }

    public String getMessage() {

        return "[ERROR] " + this.message;
    }
}
