package lotto.message;

public enum ErrorMessage {
    DIVISIBLE_BY_1000("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
    WINNING_NUMBERS_LENGTH("[ERROR] 당첨 번호는 6개여야 합니다."),
    WINNING_NUMBERS_RANGE("[ERROR] 당첨 번호의 범위는 1~45 사이여야 합니다."),
    BONUS_NUMBER_RANGE("[ERROR] 보너스 번호의 범위는 1~45 사이여야 합니다."),
    NUMBER_FORMAT_MONEY("[ERROR] 숫자로 이루어진 금액을 입력해주세요."),
    NUMBER_FORMAT_BONUS_NUMBER("[ERROR] 하나의 숫자로 이루어진 보너스 번호를 입력해주세요."),
    NUMBER_FORMAT_WINNING_NUMBERS("[ERROR] 숫자로 이루어진 당첨 번호를 입력해주세요."),
    FOUNT_MATCH_RANKING("[ERROR] 일치 횟수에 맞는 등수가 없습니다. 게임을 재시작 해주세요."),
    LOTTO_SIZE("[ERROR] 로또 발행이 잘못되었습니다. 게임을 재시작 해주세요."),
    LOTTO_RANGE("[ERROR] 로또 발행이 잘못되었습니다. 게임을 재시작 해주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String errorMessage() {
        return errorMessage;
    }
}
