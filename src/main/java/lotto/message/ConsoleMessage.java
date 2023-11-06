package lotto.message;

public enum ConsoleMessage {
    INPUT_MONEY("구입 금액을 입력해주세요."),
    PURCHASE_LOTTO("%d개를 구매했습니다."),
    RESULT_LOTTO("당첨 통계"),
    CORRECT_NUMBER("%d개 일치 (%s원) - %d개\n"),
    CORRECT_BONUS_NUMBER("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    RETURN_RATE("총 수익률은 %.1f%%입니다."),
    INPUT_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
