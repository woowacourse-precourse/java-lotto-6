package lotto.domain;

import java.util.*;

import static lotto.domain.Rank.*;

public class Result {
    private final Map<Rank, Integer> store = new EnumMap<Rank, Integer>(Rank.class);

    public Result(Lotto winningLotto, Lottos lottos, Bonus bonus) {
        initialStore();
        compare(winningLotto, lottos.getRandomLottos(), bonus.getBonus());
    }

    private void initialStore() {
        for (Rank rank : Rank.values()) {
            store.put(rank, 0);
        }
    }

    private void compare(Lotto winningLotto, List<Lotto> randomLottos, int bonus) {
        for (Lotto randomLotto : randomLottos) {
            int matchCount = count(randomLotto.getNumbers(), winningLotto.getNumbers());
            if (matchCount < FIFTH.getMatchCount()) {
                continue;
            }
            Rank rank = getRank(randomLotto.getNumbers(), matchCount, bonus);
            int previousCount = store.get(rank);
            store.put(rank, previousCount + 1);
        }
    }

    private int count(List<Integer> winningNumbers, List<Integer> numbers) {
        List<Integer> matches = new ArrayList<>(numbers);
        matches.retainAll(winningNumbers);

        return matches.size();
    }

    private Rank getRank(List<Integer> numbers, int matchCount, int bonus) {
        if (matchCount == THIRD.getMatchCount()) {
            if (isBonusMatch(numbers, bonus)) {
                return SECOND;
            }
        }
        return Rank.valueOf(matchCount);
    }

    private boolean isBonusMatch(List<Integer> lotto, int bonus) {
        return lotto.contains(bonus);
    }

    public long getReward() {
        long reward = 0L;
        for (Rank rank : Rank.values()) {
            Integer count = store.get(rank);
            reward += rank.getReward() * count;
        }
        return reward;
    }

    @Override
    public String toString() {
        return "\n당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - " + store.get(FIFTH) + "개\n" +
                "4개 일치 (50,000원) - " + store.get(FOURTH) + "개\n" +
                "5개 일치 (1,500,000원) - " + store.get(THIRD) + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + store.get(SECOND) + "개\n" +
                "6개 일치 (2,000,000,000원) - " + store.get(FIRST) + "개\n";
    }
}
