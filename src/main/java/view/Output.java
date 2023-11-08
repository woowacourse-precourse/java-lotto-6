package view;

import static view.ViewMessage.*;

public class Output {

    public static void printCount(int purchase) {
        System.out.println(TAB.getMessage());
        System.out.println(purchase + PURCHASE_RESULT.getMessage());
    }

    public static void printResult() {
        System.out.println(TAB.getMessage());
        System.out.println(RESULT.getMessage());
        System.out.println(SEPERATE.getMessage());
    }
}
