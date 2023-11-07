package lotto.view;

import lotto.domain.Lottos;

public class OutputView {

    public static void printLottoPurchaseCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public static void printAllLottoNumbers(Lottos lottos) {
        System.out.println(lottos.toString());
    }




}
