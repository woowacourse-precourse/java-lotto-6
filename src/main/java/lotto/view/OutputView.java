package lotto.view;

import static lotto.constants.Message.PURCHASED_LOTTO_AMOUNT;
import static lotto.constants.Message.WINNING_RATE;
import static lotto.constants.Message.WINNING_RESULT;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningResult;

public class OutputView {
    public void printPlayerLottoNumbers(List<Lotto> lottos) {
        System.out.printf(PURCHASED_LOTTO_AMOUNT, lottos.size());
        lottos.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        });
    }

    public void printWinningResult(WinningResult winningResult) {
        System.out.println(WINNING_RESULT);
        print(winningResult.winningStatistics());
        print(winningResult.winningRate());
    }

    private void print(Map<Rank, Integer> winningResult) {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NOTHING) {
                continue;
            }
            Integer count = winningResult.get(rank);
            String result = String.format(rank.getPrintFormat(), count);
            System.out.println(result);
        }
    }

    private void print(Double winningRate) {
        System.out.printf(WINNING_RATE, winningRate);
    }
}