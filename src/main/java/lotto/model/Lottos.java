package lotto.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    public static final int MIN_PRICE_SCORE = 3;
    public static final int INITIAL_SCORE = 0;
    private static final int PERCENT = 100;
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Map<Price, Integer> calculateScore(Lotto answer, Bonus bonus) {
        Map<Price, Integer> scores = initializeScores();
        this.lottos.stream()
            .filter(lotto -> lotto.calculateScore(answer) >= MIN_PRICE_SCORE)
            .forEach(lotto ->
                scores.put(
                    checkPrice(lotto.calculateScore(answer), lotto, bonus),
                    scores.get(checkPrice(lotto.calculateScore(answer), lotto, bonus)) + 1)
            );
        return scores;
    }

    public Float calculateProfit(Map<Price, Integer> scores, int money) {
        long profit = scores.entrySet().stream()
            .mapToLong(score -> (long) score.getKey().getReward() * score.getValue())
            .sum();
        return (float) profit / money * PERCENT;
    }

    private Price checkPrice(int score, Lotto lotto, Bonus bonus) {
        if (score == 5) {
            return checkBonus(lotto, bonus);
        }
        return Price.findByScore(score);
    }

    private Price checkBonus(Lotto lotto, Bonus bonus) {
        if (lotto.hasBonus(bonus.getNumber())) {
            return Price.SECOND;
        }
        return Price.THIRD;
    }

    private Map<Price, Integer> initializeScores() {
        Map<Price, Integer> scores = new LinkedHashMap<>();
        scores.put(Price.FIFTH, INITIAL_SCORE);
        scores.put(Price.FORTH, INITIAL_SCORE);
        scores.put(Price.THIRD, INITIAL_SCORE);
        scores.put(Price.SECOND, INITIAL_SCORE);
        scores.put(Price.FIRST, INITIAL_SCORE);
        return scores;
    }
}
