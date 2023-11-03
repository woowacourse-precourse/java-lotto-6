package lotto.View;

import java.util.List;

public class OutputView {
    public static void printPurchaseLottoAmount(int input) {
        System.out.println();
        System.out.println(input + "개를 구매했습니다.");
    }

    public static void printLottoNums(List<String> lottoNums) {
        System.out.println("[" + String.join(", ", lottoNums) + "]");
    }
}
