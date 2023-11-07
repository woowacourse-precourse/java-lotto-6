package lotto.constant;

public enum PrintMessage {
    INPUT_PRICE("구입금액을 입력해 주세요."),
    BOUGHT_LOTTO_NUMBERS("개를 구매했습니다."),
    INPUT_WIN_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    LINE("---"),
    NUMBER_UNIT("개"),
    EARNING_RATE_FRONT("총 수익률은 "),
    EARNING_RATE_BACK("%입니다.");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
