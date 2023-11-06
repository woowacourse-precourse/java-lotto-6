package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    public Lottos createLottos(int buyAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < buyAmount/1000; i++) {
            lottos.add(new Lotto(Generator.createNumbers()));
        }

        return new Lottos(lottos);
    }


    public long compareLottoNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return lottoNumbers.stream().filter(winningNumbers::contains).count();
    }

    public Boolean compareBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public int[] createResult(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] result = new int[6];
        for (Lotto lotto : lottos.getLottos()) {
            int index = checkAnswer(compareLottoNumbers(lotto.getNumbers(), winningNumbers),
                    compareBonusNumber(lotto.getNumbers(), bonusNumber));
            result[index]++;
        }
        return result;
    }


    public int checkAnswer(long count, boolean bonus) {
        int index = 0;

        if (count == 3) {
            index = 1;
        }
        if (count == 4) {
            index = 2;
        }
        if (count == 5 && !bonus) {
            index = 3;
        }
        if (count == 5 && bonus) {
            index = 4;
        }
        if (count == 6 && !bonus) {
            index = 5;
        }
        return index;
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
