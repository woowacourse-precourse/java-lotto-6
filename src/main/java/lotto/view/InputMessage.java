package lotto.view;

public final class InputMessage {
    final static String MONEY_INPUT_MESSAGE = "구매금액을 입력해주세요.";
    final static String INPUT_WINNING_NUNBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static void moneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public static void winningInputMessage() {
        System.out.println(INPUT_WINNING_NUNBERS_MESSAGE);
    }

}
