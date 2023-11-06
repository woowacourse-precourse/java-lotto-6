package lotto.view;

public class InputView {
    private static final String PAY_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String JACKPOT_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static void printPayAmountInputMessage() {
        System.out.println(PAY_AMOUNT_INPUT_MESSAGE);
    }

    public static void printJackpotNumberInputMessage() {
        System.out.println();
        System.out.println(JACKPOT_NUMBER_INPUT_MESSAGE);
    }
}
