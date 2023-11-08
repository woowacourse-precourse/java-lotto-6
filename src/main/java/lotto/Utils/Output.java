package lotto.Utils;

public class Output {
    public static void printPurchaseAmount() {
        System.out.println(Message.PURCHASE_AMOUNT.getValue());
    }

    public static void printLottoAmount() {
        System.out.print(Message.LOTTO_AMOUNT.getValue());
    }

    public static void printEnterNumbers() {
        System.out.println(Message.ENTER_NUMBERS.getValue());
    }

    public static void printBonusNumber() {
        System.out.println(Message.BONUS_NUMBER.getValue());
    }

    public static void printStartRank() {
        System.out.println(Message.START_RANK.getValue());
    }

}
