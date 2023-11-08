package lotto.view;

import lotto.Statistic;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printException(String message) {
        System.out.println(message);
    }

    public void printCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLottos(List<Integer> nums) {
        System.out.println(nums);
    }

    public void printResult(Map<Statistic, Integer> winningLotto) {
        System.out.println("\n당첨 통계\n" + "---");
        for (Statistic s : Statistic.values()) {
            System.out.println(s.getMessage() + winningLotto.get(s) + "개");
        }
    }

    public void printTotal(double percent) {
        System.out.printf("총 수익률은 %.1f%%입니다.", percent);
    }
}
