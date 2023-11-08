package controller;

import domain.Lotto;
import domain.Rank;
import domain.Result;
import domain.WinningLotto;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import view.OutputView;

public class LottoController {

    private static Result calculateResult(List<Lotto> totalLottos, WinningLotto winningLotto) {
        Map<Rank, Integer> result = new HashMap<>();
        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, 0));
        for (Lotto lotto : totalLottos) {
            Rank rank = winningLotto.calculateRank(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return new Result(result);
    }

    private static void printResult(Result result, double earningsRate) {
        OutputView.printResultTitle();
        OutputView.printWinningResults(result);
        OutputView.printEarningsRate(earningsRate);
    }
}