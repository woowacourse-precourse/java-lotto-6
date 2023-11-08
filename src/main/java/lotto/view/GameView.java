package lotto.view;

public class GameView {
    private GameView() {

    }

    public static void printAmountInputPhrase() {
        System.out.println(Phrase.AMOUNT_INPUT.getPrintPhrase());
    }

    public static void printPurchaseCountOutputPhrase(int num) {
        System.out.println(num + Phrase.PURCHASE_COUNT_OUTPUT.getPrintPhrase());
    }

    public static void printWinningNumberInputPhrase() {
        System.out.println(Phrase.WINNING_NUMBER_INPUT.getPrintPhrase());
    }
}
