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

    public static Map<Prize, Integer> checkWinning(List<Lotto> lottos, Lotto winningLotto, Integer bonusNumber) {
        int count;
        // 초기화 메서드
        Map<Prize, Integer> lottoResult = new HashMap<>();
        for (Prize prize : Prize.values()) {
            lottoResult.put(prize, 0);
        }

        for (Lotto lotto : lottos) {
            // 일치 개수 return 메서드
            count = 0;
            for (int i = 0; i < 6; i++) {
                if (lotto.getNumbers().contains(winningLotto.getNumbers().get(i))) {
                    count++;
                }
            }
            Prize prize = Prize.rank(count, lotto.getNumbers().contains(bonusNumber));

            lottoResult.replace(prize, lottoResult.get(prize) + 1);
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
