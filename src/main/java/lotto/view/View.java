package lotto.view;

public class View {
} enum InputMessage {
    BUY_MONEY("구입금액을 입력해 주세요."),
    WINNING_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 볼을 입력해 주세요.");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
enum OutputMessage {
    Analysis("당첨 통계\n---"),
    SAME("%s개 일치"),
    COST(" (%,d원) "),
    COUNT("- %s개"),
    PROFIT("총 수익률은 %.1f%%입니다."),
    BUY("%s개를 구매했습니다."),
    SAME_BONUS(", 보너스 볼 일치");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
