package lotto.enums;

public enum ErrorMessage {
    ERROR_OF_NOT_NUMBER("[ERROR] 입력값은 정수형 숫자여야 합니다!"),
    ERROR_OF_MONEY_UNDER_1K("[ERROR] 구입금액은 1,000원 이상의 값이어야 합니다!"),
    ERROR_OF_MONEY_NOT_MULTIPLES("[ERROR] 구입금액은 1,000원 단위여야 합니다!"),
    ERROR_OF_WINNIG_NUMBER_OVER_RANGE("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다!"),
    ERROR_OF_WINNIG_NUMBER_NOT_SIX_DIGITS("[ERROR] 당첨 번호는 6자리 숫자여야 합니다!"),
    ERROR_OF_WINNIG_NUMBER_SAME_NUMBER("[ERROR] 당첨 번호는 서로 다른 숫자여야 합니다!"),
    ERROR_OF_BONUS_NUMBER_OVER_RANGE("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다!"),
    ERROR_OF_BONUS_NOT_ONE_DIGIT("[ERROR] 보너스 번호는 1자리 숫자여야 합니다!"),
    ERROR_OF_BONUS_NOT_CONTAIN_WINNING_NUMBERS("[ERROR] 보너스 번호는 당첨 번호가 아닌 숫자여야 합니다!");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
