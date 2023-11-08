package lotto.domain;

import lotto.util.Constants;
import lotto.util.Rank;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.util.Rank.*;
import static lotto.view.OutputView.*;

public class Result {

    private final Lottos lottos;
    private final List<Integer> winningNumber;
    private final int bonusNumber;
    private final Map<Rank, Integer> winningCounts = new LinkedHashMap<>();

    public Result(Lottos lottos, List<Integer> winningNumber, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        init();
    }

    public void init() {
        winningCounts.put(FIFTH, 0);
        winningCounts.put(FOURTH, 0);
        winningCounts.put(THIRD, 0);
        winningCounts.put(SECOND, 0);
        winningCounts.put(FIRST, 0);
    }

    public int gameResult() {
        for (Lotto lotto : lottos.getLottos()) {
            int matchingNumber = countMatchingNumbers(lotto);
            boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);

            if (matchingNumber < 3) {
                continue;
            }
            Rank rank = getRank(matchingNumber);
            if (rank.getIndex() == 5 && hasBonusNumber) {
                winningCounts.put(SECOND, winningCounts.get(rank) + 1);
            }
            winningCounts.put(rank, winningCounts.get(rank) + 1);
        }

        return printResult(winningCounts);
    }

    private int countMatchingNumbers(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .mapToInt(number -> number)
                .filter(winningNumber::contains)
                .count();
    }
}
