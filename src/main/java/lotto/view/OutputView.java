package lotto.view;

import lotto.Lotto;

import java.util.List;

public class OutputView {
    public static void printLottos(int lottoCount) {
        printPurchasedLottoCount(lottoCount);
    }

    public static void printPurchasedLottoCount(int count) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
    }
}