package lotto.domain;

import lotto.enums.Ranking;
import lotto.utils.RandomGenerator;

import java.util.*;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1_000;

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }

    public List<Lotto> issueLottos(int money) {
        int size = money / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(new Lotto(RandomGenerator.generate()));
        }
        return lottos;
    }

    public Map<Ranking, Integer> rank(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Ranking, Integer> rankingCounts = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values()).forEach(key -> rankingCounts.put(key, 0));

        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        for (Lotto lotto : lottos) {
            int corrects = lotto.findCorrects(winningNumbers);
            boolean bonus = lotto.contains(bonusNumber);
            Ranking ranking = Ranking.findRanking(corrects, bonus);
            rankingCounts.put(ranking, rankingCounts.get(ranking) + 1);
        }

        return rankingCounts;
    }
}
