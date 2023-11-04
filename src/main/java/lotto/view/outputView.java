package lotto.view;

import java.util.List;
import java.util.Map;

public class outputView {
    public void outputAmountOfLotto(int amountOfLotto) {
        System.out.println(amountOfLotto + "개를 구매했습니다.");
    }

    public void outputLottosNumbers(List<List<Integer>> outputRandomLottoNumber) {
        for (List<Integer> row : outputRandomLottoNumber) {
            System.out.print("[");
            randomLottosNumbers(row);
            System.out.print("]");
            System.out.println();
        }
    }

    public void randomLottosNumbers(List<Integer> row) {
        for (int i = 0; i < row.size(); i++) {
            System.out.print(row.get(i));
            if (i < row.size() - 1) {
                System.out.println(", ");
            }
        }
    }

    public void outputWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");

    }

    public void outputReturn(double rateReturn) {
        System.out.println("총 수익률은 " + rateReturn + "입니다.");
    }

}
