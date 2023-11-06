package lotto.io;

public enum Command {
    ASK_AMOUNT("구입금액을 입력해 주세요."),
    ASK_WINNING_NUMBERS("당첨 번호를 입력해 주세요.");

    private String command;

    Command(String command) {
        this.command = command;
    }

    public String prompt() {
        return command;
    }
}
