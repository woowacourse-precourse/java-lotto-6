package lotto.view;

import lotto.model.Lotto;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    public void printAllLottoNumbers(List<Lotto> lottos) {
        int numberOfLottos = lottos.size();
        System.out.println("\n" + numberOfLottos + "개를 구매했습니다.");

        for(Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        }
    }

    public void printTotalResult(int[][] totalResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + totalResult[3][0] + "개");
        System.out.println("4개 일치 (50,000원) - " + totalResult[4][0] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + totalResult[5][0] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + totalResult[5][1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + totalResult[6][0] + "개");
    }

    public void printReturnRate(double returnRate) {
        returnRate *= 100;
        DecimalFormat decimalFormat = new DecimalFormat("#,###.#");
        String formattedReturnRate = decimalFormat.format(returnRate);
        System.out.println("총 수익률은 " + formattedReturnRate + "%입니다.");
    }
}
