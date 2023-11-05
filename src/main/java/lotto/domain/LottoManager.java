package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Prize;

public class LottoManager {

    public static List<Lotto> sortLottos(List<Lotto> lottos) {
        List<Lotto> sortedLottos = new ArrayList<>();

        for (Lotto lotto : lottos) {
            List<Integer> sortedNumber = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedNumber);
            Lotto sortedLotto = new Lotto(sortedNumber);
            sortedLottos.add(sortedLotto);
        }

        return sortedLottos;
    }

    public static Map<Prize, Integer> initializePrize() {
        Map<Prize, Integer> result = new HashMap<>();
        for (Prize prize : Prize.values()) {
            result.put(prize, 0);
        }
        return result;
    }

    public static Integer countMatching(Lotto userLotto, Lotto winningLotto) {
        Integer countMatching = 0;
        for (int i = 0; i < 6; i++) {
            if (userLotto.getNumbers().contains(winningLotto.getNumbers().get(i))) {
                countMatching++;
            }
        }
        return countMatching;
    }

    public static Map<Prize, Integer> checkWinning(List<Lotto> lottos, Lotto winningLotto, Integer bonusNumber) {
        Map<Prize, Integer> lottoResult = initializePrize();
        for (Lotto userLotto : lottos) {
            Integer countMatching = countMatching(userLotto, winningLotto);

            if (countMatching >= Prize.FIFTH.getMatchingNumber()) {
                Prize prize = Prize.rank(countMatching, userLotto.getNumbers().contains(bonusNumber));
                lottoResult.replace(prize, lottoResult.get(prize) + 1);
            }

        }

        return lottoResult;
    }


    public static Double calculateEarningRate(List<Integer> lottoResult, List<Integer> prizeMoney, Integer lottoCount) {
        int sum = 0;

        for (int i = 0; i < lottoResult.size(); i++) {
            sum += lottoResult.get(i) * prizeMoney.get(i);
        }

        return ((double) sum / (lottoCount * 1000)) * 100;

    }

}
