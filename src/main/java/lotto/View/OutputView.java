package lotto.View;

import java.util.List;

public class OutputView {

    private static void printResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Matching matchLotto = new Matching(lottos, winningNumbers, bonusNumber);
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(matchLotto);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", matchLotto.calculateTotalWinningRate());
    }
}
