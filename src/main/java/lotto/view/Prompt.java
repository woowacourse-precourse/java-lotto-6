package lotto.view;

public enum Prompt {
    MESSAGE_INPUT_MONEY("구입금액을 입력해 주세요."),
    FORMAT_NUMBER_OF_PLAYS("%d개를 구매했습니다."),
    FORMAT_LOTTO_NUMBERS("[%s]");

    Prompt(String message) {
        this.message = message;
    }

    private final String message;

    public void println() {
        System.out.println(message);
    }

    public void println(int number) {
        System.out.printf((message) + "%n", number);
    }

    public void println(String content) {
        System.out.printf((message) + "%n", content);
    }
}
