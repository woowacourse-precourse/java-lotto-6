package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_PURCHASED_MESSAGE = "\n%d개를 구매했습니다.";

    public static void printNumberOfLottoPurchased(int numberOfLottosPurchased) {
        System.out.printf(NUMBER_OF_LOTTOS_PURCHASED_MESSAGE, numberOfLottosPurchased);
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatics(List<Integer> finalMatchNumbers, double RateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + finalMatchNumbers.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + finalMatchNumbers.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + finalMatchNumbers.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + finalMatchNumbers.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + finalMatchNumbers.get(0) + "개");
        System.out.println("총 수익률은 " + RateOfReturn + "%입니다.");
    }
}
