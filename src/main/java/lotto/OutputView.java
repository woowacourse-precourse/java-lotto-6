package lotto;

import java.util.List;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printEmptyLine() {
        System.out.println();
    }


    public static void printLottoNumbers(int numberOfPurchasedLottos, List<Lotto> lottos) {
        printMessage(numberOfPurchasedLottos + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
