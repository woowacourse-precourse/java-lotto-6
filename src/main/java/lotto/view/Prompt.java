package lotto.view;

public enum Prompt {

    WAIT_FOR_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WAIT_FOR_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    WAIT_FOR_BONUS_NUMBER("보너스 번호를 입력해주세요");

    private final String msg;

    private Prompt(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return this.msg;
    }
}
