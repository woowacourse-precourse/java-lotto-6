package lotto.view.constant;

public enum Instructions {
    MESSAGE_OF_ENTERING_LOTTO_AMOUNT("구입금액을 입력해 주세요."),

    MESSAGE_OF_PURCHASE_COUNT("\n%d개를 구매했습니다.\n");

    private final String prompts;

    Instructions(String prompts) {
        this.prompts = prompts;
    }

    public String getPrompts() {
        return prompts;
    }

}
