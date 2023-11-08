package lotto.domain;

import java.util.*;

import static lotto.domain.Rank.*;

public class Result {
    private final Map<Rank, Integer> store = new EnumMap<Rank, Integer>(Rank.class);

    public Result(Lotto winningLotto, Lottos lottos, Bonus bonus) {
        initialStore();
        compare(winningLotto, lottos.getRandomLottos(), bonus.getBonus());
    }

    public int getReward() {
        int reward = 0;
        for (Rank rank : Rank.values()) {
            Integer count = store.get(rank);
            reward += rank.getReward() * count;
        }
        return reward;
    }

    private void initialStore() {
        for (Rank rank : Rank.values()) {
            store.put(rank, 0);
        }
    }

    private void compare(Lotto winningLotto, List<Lotto> randomLottos, int bonus) {
        for (Lotto randomLotto : randomLottos) {
            int matchCount = count(randomLotto.getNumbers(), winningLotto.getNumbers());

            if (fail(matchCount)) {
                continue;
            }
            Rank rank = getRank(randomLotto.getNumbers(), matchCount, bonus);

            int previousCount = store.get(rank);
            store.replace(rank, previousCount + 1);
        }
    }

    private int count(List<Integer> winningNumbers, List<Integer> numbers) {
        List<Integer> matches = new ArrayList<>(numbers);
        matches.retainAll(winningNumbers);

        return matches.size();
    }

    private boolean fail(int matchCount) {
        return matchCount < FIFTH.getMatchCount();
    }

    private Rank getRank(List<Integer> numbers, int matchCount, int bonus) {
        if (isSecond(numbers, matchCount, bonus)) {
            return SECOND;
        }
        return Rank.valueOf(matchCount);
    }

    private boolean isSecond(List<Integer> numbers, int matchCount, int bonus) {
        return matchCount == THIRD.getMatchCount() && numbers.contains(bonus);
    }

    public Map<Rank, Integer> getStore() {
        return store;
    }
}
