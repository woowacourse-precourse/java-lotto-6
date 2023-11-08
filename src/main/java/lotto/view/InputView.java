package lotto.view;

public class InputView {

    private static final String INPUT_BUY_AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static void printInputBuyAmountRequest() {
        System.out.println(INPUT_BUY_AMOUNT_REQUEST_MESSAGE);
    }

    public static void printInputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }
}
