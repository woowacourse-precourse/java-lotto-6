package lotto.domain;

import lotto.configuration.Constants;

import java.util.*;

import static lotto.configuration.Constants.Message.*;
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

    public int getReward() {
        int reward = 0;
        for (Rank rank : Rank.values()) {
            Integer count = store.get(rank);
            reward += rank.getReward() * count;
        }
        return reward;
    }

    @Override
    public String toString() {
        return SHOW_RESULT +
                FIFTH_IS + store.get(FIFTH) + Constants.Message.COUNT +
                FOURTH_IS + store.get(FOURTH) + Constants.Message.COUNT +
                THIRD_IS + store.get(THIRD) + Constants.Message.COUNT +
                SECOND_IS + store.get(SECOND) + Constants.Message.COUNT +
                FIRST_IS + store.get(FIRST) + Constants.Message.COUNT;
    }
}
