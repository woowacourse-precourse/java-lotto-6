package lotto.view.constants;

public enum Front {
    REQUEST_PERCHASE_AMOUNT("구입 금액을 입력해 주세요."),
    CHECK_LOTTO_TICKETS("%d개를 구매했습니다."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),
    SHOW_THE_WINNING_STATISTICS("당첨 통계");

    private final String message;

    Front(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
