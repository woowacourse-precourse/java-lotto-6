package lotto.message;

public enum Input {
    PRICE_PROMPT("구입금액을 입력해 주세요."),
    WINNING_NUMBER_PROMPT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_PROMPT("보너스 번호를 입력해 주세요.");

    private final String message;

    Input(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(this.message);
    }
}
