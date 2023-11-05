package lotto;

import java.util.List;

public class OutputHandler {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLineBreak() {
        System.out.println();
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
