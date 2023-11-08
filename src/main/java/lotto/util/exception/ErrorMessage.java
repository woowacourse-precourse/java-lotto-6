package lotto.util.exception;

public enum ErrorMessage {
    NOT_CORRECT_NUMBER("[ERROR] 올바른 숫자를 입력해주세요."),
    NOT_ONLY_NUMBER("[ERROR] 숫자만 입력해주세요."),
    NOT_THOUSAND("[ERROR] 구입 금액 단위는 최소 천원이면서 천원 단위여야 합니다."),
    NOT_RIGHT_BOUNDARY("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_SIX_NUMBER("[ERROR] 6개의 숫자를 입력해주세요."),
    SHOULD_NOT_SAME_WITH_WINNING_NUMBERS("[ERROR] 보너스 번호는 당첨 번호들과 달라야 합니다."),
    SHOULD_BE_DISTINCT("[ERROR] 중복된 숫자들은 입력하지 마세요");

    private final String errorMessage;
    private ErrorMessage(final String message) {
        this.errorMessage = message;
    }
    @Override
    public String toString() {
        return errorMessage;
    }
}
