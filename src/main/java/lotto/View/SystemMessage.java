package lotto.View;

public enum SystemMessage {
    GUESS_BUY_LOTTO("구입금액을 입력해주세요."),
    RESULT_BUY_LOTTO("%d개를 구매했습니다."),

    GUESS_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    GUESS_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),

    RESULT_MATCHING_NUMBERS("당첨 통계\n" + "---"),

    THREE_MATCH("3개 일치 (5,000원) - %d개"),
    FOUR_MATCH("4개 일치 (50,000원) - %d개"),
    FIVE_MATCH("5개 일치 (1,500,000원) - %d개"),
    FIVE_BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_MATCH("6개 일치 (2,000,000,000원) - %d개"),

    RESULT_RATE("총 수익률은 %f%입니다."),

    ERROR_INVALID_LOTTO_AMOUNT("[ERROR] 1,000원 단위로 입력해 주세요."),
    ERROR_INVALID_INPUT("[ERROR] 숫자만 입력해 주세요."),

    ERROR_INVALID_WINNING_NUMMERS("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
