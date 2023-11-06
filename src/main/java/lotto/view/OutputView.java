package lotto.view;

import static lotto.constant.message.OutputMessage.PURCHASE;

import java.util.List;

public class OutputView {
    public static void printPurchaseCount(int count) {
        System.out.printf(PURCHASE.getMessage(), count);
    }

    public static void printLottoNumbers(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public static void printError(String error) {
        System.out.println(error);
        printLineChanging();
    }

    public static void printLineChanging() {
        System.out.println();
    }
}
