package lotto.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlayLotto {
    private final int MIN_PRICE_SCORE = 3;
    private final int INITIAL_SCORE = 0;
    private final int PERCENT = 100;

    private final List<Lotto> lottos;

    public PlayLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Map<Price, Integer> calculateScore(Lotto answer, BonusNumber bonusNumber) {
        Map<Price, Integer> scores = initializeScores();
        for (Lotto lotto : this.lottos) {
            int lottoScore = lotto.calculateScore(answer);
            if (lottoScore >= MIN_PRICE_SCORE) {
                Price price = checkPrice(lottoScore, lotto, bonusNumber);
                scores.put(price, scores.get(price) + 1);
            }
        }
        return scores;
    }


    public Float calculateProfit(Map<Price, Integer> scores, int money) {
        long profit = 0;
        for (Map.Entry<Price, Integer> entry : scores.entrySet()) {
            Price price = entry.getKey();
            int count = entry.getValue();
            profit += (long) price.getReward() * count;
        }
        return (float) profit / money * PERCENT;
    }


    private Price checkPrice(int score, Lotto lotto, BonusNumber bonusNumber) {
        if (score == 5) {
            return checkBonus(lotto, bonusNumber);
        }
        return Price.findByScore(score);
    }

    private Price checkBonus(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.hasBonus(bonusNumber.getNum())) {
            return Price.SECOND;
        }
        return Price.THIRD;
    }

    private Map<Price, Integer> initializeScores() {
        Map<Price, Integer> scores = new LinkedHashMap<>();
        for (Price price : Price.values()) {
            scores.put(price, INITIAL_SCORE);
        }
        return scores;
    }

}
