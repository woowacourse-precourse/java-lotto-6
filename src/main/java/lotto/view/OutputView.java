package lotto;

import lotto.Lotto;

public class OutputView {
    public void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottoNumbers(int count, Lotto randomLottoNumbers) {
        System.out.println(count + "개를 구매했습니다.");
        
        for (int i = 0; i < count; i++)
            System.out.println(randomLottoNumbers);
    }

    public void printResult(enum Result) {
        System.out.println("당첨 통계 \n---");
        System.out.println("3개 일치 (5,000원) - " + Result.COUNTTHREE.getValue() + "개");
        System.out.println("4개 일치 (50,000원) - " + Result.COUNTFOUR.getValue() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Result.COUNTFIVE.getValue() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Result.COUNTFIVEBONUS.getValue() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Result.COUNTSIX.getValue() + "개");
    }

    public void printProfit(int profit) {
        //double profit = Math.round((prize/purchaseAmount*100)/100.0);
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
