package lotto.view;

public class OutputView {

    private final static String OUTPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String OUTPUT_AMOUNT_LOTTO_MESSAGE = "%d개를 구매했습니다.";
    private final static String OUTPUT_WINNER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String OUTPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String BLANK_LINE = "";


    public void printPurchaseMoneyMessage() {
        System.out.println(OUTPUT_PURCHASE_MONEY_MESSAGE);
    }

    public void printAmountLottoMessage(int ammount) {
        System.out.printf(OUTPUT_AMOUNT_LOTTO_MESSAGE, ammount);
    }

    public void printWinnerNumberMessage() {
        System.out.println(OUTPUT_WINNER_NUMBER_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println(OUTPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printBlankLine() {
        System.out.println(BLANK_LINE);
    }
}
