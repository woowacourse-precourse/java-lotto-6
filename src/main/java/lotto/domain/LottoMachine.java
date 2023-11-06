package lotto.domain;

import lotto.enums.Ranking;
import lotto.utils.RandomGenerator;

import java.util.*;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1_000;

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }

    public Lottos issueLottos(Money money) {
        int size = money.getAmount() / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(new Lotto(RandomGenerator.generate()));
        }
        return new Lottos(List.copyOf(lottos));
    }

    public Map<Ranking, Integer> rank(Lottos lottos, WinningLotto winningLotto) {
        Map<Ranking, Integer> rankingCounts = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values()).forEach(key -> rankingCounts.put(key, 0));

        Lotto winningNumbers = winningLotto.getLotto();
        int bonusNumber = winningLotto.getBonusNumber();

        for (Lotto lotto : lottos) {
            int corrects = lotto.findCorrects(winningNumbers);
            boolean bonus = lotto.contains(bonusNumber);
            Ranking ranking = Ranking.findRanking(corrects, bonus);
            rankingCounts.put(ranking, rankingCounts.get(ranking) + 1);
        }

        return Map.copyOf(rankingCounts);
    }
}
