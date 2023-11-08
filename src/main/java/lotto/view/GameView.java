package lotto.view;

import java.util.List;

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

    public static void printBonusNumberInputPhrase() {
        System.out.println(Phrase.BONUS_NUMBER_INPUT.getPrintPhrase());
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
