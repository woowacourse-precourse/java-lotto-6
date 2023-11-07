package view;

import domain.Lotto;

public class OutputView {
    public static void printPurchaseAmount(int lottoAmount){
        System.out.println("\n"+lottoAmount+"개를 구매했습니다.");
    }
    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers().toString());
    }
    public static void printStatisticsResult(Lotto lotto) {
        System.out.println("당첨 통계\n ---");
    }

}
