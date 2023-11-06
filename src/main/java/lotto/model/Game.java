package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    public Lottos createLottos(int buyAmount) {
        return Lottos.from(buyAmount);
    }

    public int[] createResult(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoChecker lottoChecker = new LottoChecker();
        return lottoChecker.createResult(lottos, winningNumbers, bonusNumber);
    }


    public float calculateProfitRate(float buyAmount, int[] result) {
        float winningPrice = calculateWinningPrice(result);

        return (winningPrice / buyAmount) * 100;
    }


    public float calculateWinningPrice(int[] result) {
        float profit = 0;
        for (int i = 1; i <= 5; i++) {
            if (i == 1 && result[i] != 0) {
                profit += 5000 * result[i];
            }
            if (i == 2 && result[i] != 0) {
                profit += 50000 * result[i];
            }
            if (i == 3 && result[i] != 0) {
                profit += 1500000 * result[i];
            }
            if (i == 4 && result[i] != 0) {
                profit += 30000000 * result[i];
            }
            if (i == 5 && result[i] != 0) {
                profit += 2000000000 * result[i];
            }
        }

        return profit;
    }


}
