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

    public static void printMatchNumbers(List<Integer> matchNumber) {
        System.out.println(Phrase.STATISTICS.getPrintPhrase());
        System.out.println(Phrase.DELIMITER.getPrintPhrase().repeat(3));
        System.out.println(Phrase.THREE_MATCH.getPrintPhrase() + " " + Phrase.DELIMITER.getPrintPhrase() + " " + matchNumber.get(3) + Phrase.COUNT.getPrintPhrase());
        System.out.println(Phrase.FOUR_MATCH.getPrintPhrase() + " " + Phrase.DELIMITER.getPrintPhrase() + " " + matchNumber.get(4) + Phrase.COUNT.getPrintPhrase());
        System.out.println(Phrase.FIVE_MATCH.getPrintPhrase() + " " + Phrase.DELIMITER.getPrintPhrase() + " " + matchNumber.get(5) + Phrase.COUNT.getPrintPhrase());
        System.out.println(Phrase.FIVE_BONUS_MATCH.getPrintPhrase() + " " + Phrase.DELIMITER.getPrintPhrase() + " " + matchNumber.get(7) + Phrase.COUNT.getPrintPhrase());
        System.out.println(Phrase.SIX_MATCH.getPrintPhrase() + " " + Phrase.DELIMITER.getPrintPhrase() + " " + matchNumber.get(6) + Phrase.COUNT.getPrintPhrase());
    }

    public static void printRevenue(int price, int amount) {
        double profitPercentage = ((double) price / amount) * 100;
        System.out.println(String.format(Phrase.REVENUE.getPrintPhrase(), profitPercentage));
    }
}
