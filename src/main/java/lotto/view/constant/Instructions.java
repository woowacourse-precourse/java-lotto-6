package lotto.view.constant;

public enum Instructions {
    MESSAGE_OF_ENTERING_LOTTO_AMOUNT("구입금액을 입력해 주세요."),

    MESSAGE_OF_PURCHASE_COUNT("\n%d개를 구매했습니다.\n"),
    MESSAGE_OF_ENTERING_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    MESSAGE_OF_ENTERING_BONUS_NUMBERS("보너스 번호를 입력해 주세요.");

    private final String prompts;

    Instructions(String prompts) {
        this.prompts = prompts;
    }

    public String getPrompts() {
        return prompts;
    }

}
