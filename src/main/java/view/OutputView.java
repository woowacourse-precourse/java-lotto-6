package view;

import java.util.List;
import domain.Calculator;
import domain.Lotto;

public class OutputView {
    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoBundle(List<Lotto> lottoBundle) {
        for (Lotto lotto : lottoBundle) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printPrizeDescribe(Calculator calculator) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + calculator.getFifthPrize() + "개");
        System.out.println("4개 일치 (50,000원) - " + calculator.getFourthPrize() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + calculator.getThirdPrize() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + calculator.getSecondPrize() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + calculator.getFirstPrize() + "개");
    }

    public void printEarningRate(String earningRate) {
        System.out.print("총 수익률은 " + earningRate + "입니다.");
    }

    public void lineBreak() {
        System.out.println();
    }
}
