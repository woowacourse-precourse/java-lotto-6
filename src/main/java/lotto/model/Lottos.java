package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    public static final int MIN_SCORE = 3;
    public static final int NONE_SCORE = 0;
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLotto() {
        return lottos;
    }

    public Map<Price, Integer> calculateScore(Lotto answer, Bonus bonus) {
        Map<Price, Integer> scores = initializeScores();
        Price price;
        for (Lotto lotto : lottos) {
            price = checkPrice(lotto.calculateScore(answer), lotto, bonus);
            scores.put(price, scores.get(price) + 1);
        }
        return scores;
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
        Map<Price, Integer> scores = new HashMap<>();
        scores.put(Price.FIRST, NONE_SCORE);
        scores.put(Price.SECOND, NONE_SCORE);
        scores.put(Price.THIRD, NONE_SCORE);
        scores.put(Price.FORTH, NONE_SCORE);
        scores.put(Price.FIFTH, NONE_SCORE);
        return scores;
    }
}
