package lotto.exception;

public enum WinnerExceptionMessage {
    WRONG_WINNER_LOTTO_LENGTH("[ERROR] 6개의 당첨 번호를 입력해주세요."),
    WRONG_WINNER_LOTTO_NUMBER_RANGE("[ERROR] 입력하신 당첨 번호가 1~45 범위를 벗어났습니다. 1~45 내의 숫자를 입력해주세요"),
    DUPLICATED_WINNER_NUMBER("[ERROR] 입력하신 당첨 번호에 중복된 숫자가 있습니다. 중복된 숫자를 입력할 수 없습니다."),
    WRONG_BONUS_NUMBER_RANGE("[ERROR] 입력하신 보너스 숫자가 1~45 범위를 벗어납니다. 1~45 내의 숫자를 입력해주세요."),
    DUPLICATED_NUMBER_BETWEEN_WINNER_NUMBER_AND_BONUS_NUMBER("[ERROR] 입력하신 당첨 번호와 보너스 번호 중에 중복된 숫자가 있습니다. 중복되지 않는 숫자를 입력해주세요.");
    private final String message;

    WinnerExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
