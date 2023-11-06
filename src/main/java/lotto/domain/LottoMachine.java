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
            Ranking ranking = findRanking(corrects, bonus);
            rankingCounts.put(ranking, rankingCounts.get(ranking) + 1);
        }

        return rankingCounts;
    }

    private Ranking findRanking(int corrects, boolean bonus) {
        if (Ranking.FIRST.getCorrects() == corrects) {
            return Ranking.FIRST;
        }
        if (Ranking.SECOND.isBonus() == bonus
                && Ranking.SECOND.getCorrects() == corrects) {
            return Ranking.SECOND;
        }
        if (Ranking.THIRD.isBonus() == bonus
                && Ranking.THIRD.getCorrects() == corrects) {
            return Ranking.THIRD;
        }
        if (Ranking.FORTH.getCorrects() == corrects) {
            return Ranking.FORTH;
        }
        if (Ranking.FIFTH.getCorrects() == corrects) {
            return Ranking.FIFTH;
        }
        return Ranking.BLANK;
    }
}
