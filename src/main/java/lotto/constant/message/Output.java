package lotto.constant.message;

public enum Output {
    PRICE("구입금액을 입력해 주세요."),
    PURCHASE("개를 구매했습니다."),
    WIN("당첨 통계\n---"),
    SAME("%d개 일치 (%,d원) - %d개"),
    BONUS("5개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    Output(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
