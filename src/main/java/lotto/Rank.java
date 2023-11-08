package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Rank {
    private final List<List<Integer>> lottos;
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;
    HashMap<String, Integer> count = new HashMap<>();

    public Rank(List<List<Integer>> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.count.put("first", 0);
        this.count.put("second", 0);
        this.count.put("third", 0);
        this.count.put("fourth", 0);
        this.count.put("fifth", 0);
        this.compareAll();
    }

    private void compareAll() {
        this.lottos.forEach(this::setRank);
    }

    private void setRank(List<Integer> lotto) {
        Integer sameBall = compareOne(lotto);
        setCount(sameBall, RankConfig.FIRST_BALL.get(), "first");
        setBonusNumberCount(lotto, RankConfig.SECOND_BALL.get(), "second");
        setCount(sameBall, RankConfig.THIRD_BALL.get(), "third");
        setCount(sameBall, RankConfig.FOURTH_BALL.get(), "fourth");
        setCount(sameBall, RankConfig.FIFTH_BALL.get(), "fifth");
    }

    private void setCount(Integer sameBall, Integer sameBallTarget, String countKey) {
        if (sameBall.equals(sameBallTarget)) {
            count.put(countKey, count.get(countKey) + 1);
        }
    }

    private void setBonusNumberCount(List<Integer> lotto, Integer sameBallTarget, String countKey) {
        Integer sameBall = compareOne(lotto);
        if (sameBall.equals(sameBallTarget) && lotto.contains(bonusNumber)) {
            count.put(countKey, count.get(countKey) + 1);
        }
    }

    private Integer compareOne(List<Integer> lotto) {
        AtomicReference<Integer> sameBall = new AtomicReference<>(0);
        lotto.forEach(number -> {
            if (winningNumbers.contains(number)) sameBall.updateAndGet(v -> v + 1);
        });
        return sameBall.get();
    }

    public HashMap<String, Integer> getCount() {
        return count;
    }
}
