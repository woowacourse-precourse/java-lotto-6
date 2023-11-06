package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Comparator {
    public static List<LottoResult> compare(List<Lotto> playerLottos, Lotto winningLotto, Bonus bonus) {
        List<LottoResult> lottoResults = new ArrayList<>();

        for (Lotto playerLotto : playerLottos) {
            int lottoCount = compareLotto(playerLotto, winningLotto);
            boolean isBonus = compareBonus(playerLotto, bonus.getNum());

            LottoResult lottoResult = new LottoResult(lottoCount, isBonus);
            lottoResults.add(lottoResult);
        }

        return lottoResults;
    }

    private static int compareLotto(Lotto playerLotto, Lotto winningLotto) {
        List<Integer> player = playerLotto.getNumbers();
        List<Integer> winning = winningLotto.getNumbers();

        int lottoCount = 0;
        for (Integer i : player) {
            if (winning.contains(i))
                lottoCount++;
        }

        return lottoCount;
    }

    private static boolean compareBonus(Lotto playerLotto, int bonus) {
        return playerLotto.getNumbers().contains(bonus);
    }
}
