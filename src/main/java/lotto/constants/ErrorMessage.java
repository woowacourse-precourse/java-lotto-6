package lotto.constants;

public enum ErrorMessage {
    ERROR_AMOUNT_LESS_1000("로또 구입 금액을 1000원 이상 입력해주세요."),
    ERROR_AMOUNT_UNDIVIDED_1000("로또 구입 금액을 1000원 단위로 입력해주세요."),
    ERROR_AMOUNT_OTHER_STRING("로또 구입 금액을 1000원 단위로 숫자만 입력해주세요."),
    ERROR_PRIZE_NUM_LESS_1_OVER_45("로또 번호는 1부터 45 사이의 숫자로 입력해주세요."),
    ERROR_PRIZE_NUM_SIZE_LESS_OR_OVER_6("로또 번호는 6개만 입력해주세요."),
    ERROR_PRIZE_NUM_OVERLAP("로또 번호 6개를 중복되지 않게 입력해주세요."),
    ERROR_PRIZE_NUM_OTHER_STRING("로또 번호 6개를 쉼표(,)로 구분해 입력해주세요."),
    ERROR_BONUS_NUM_OVERLAP("보너스 번호는 당첨 번호 6개와 중복되지 않는 숫자로 입력해주세요.");

    private String errorMessage;
    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // Getter
    public String getErrorMessage() {
        return "[ERROR] " + errorMessage;
    }
}
