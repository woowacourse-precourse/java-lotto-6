package lotto.matcher.impl;

import lotto.config.LottoConfig;
import lotto.config.LottoPrize;
import lotto.config.PrizePolicyConfig;
import lotto.lotto.AnswerLotto;
import lotto.lotto.Lotto;
import lotto.matcher.Matcher;

public class LottoMatcher implements Matcher {
    private boolean matched(Integer numberOfLotto, AnswerLotto answerLotto) {
        for (Integer numberOfAnswer : answerLotto.getNumbers()) {
            if (numberOfLotto.equals(numberOfAnswer)) {
                return true;
            }
        }
        return false;
    }

    private boolean matchBonus(Lotto lotto, Integer bonus) {
        for (Integer numberOfLotto : lotto.getNumbers()) {
            if (numberOfLotto.equals(bonus)) {
                return true;
            }
        }
        return false;
    }

    private LottoPrize checkSecond(LottoPrize prize, boolean bonus) {
        if (prize.getReward() == LottoConfig.SECOND_PRIZE.getNum() && !bonus)
            return PrizePolicyConfig.PRIZES.getPrizes().get(3);
        return prize;
    }

    private LottoPrize matchPrize(int count, boolean bonus) {
        for (LottoPrize prize : PrizePolicyConfig.PRIZES.getPrizes()) {
            if (prize.getMatchNumber() == count) {
                return checkSecond(prize, bonus);
            }
        }
        return new LottoPrize(-1, 0, false, 0);
    }
    @Override
    public LottoPrize match(Lotto lotto, AnswerLotto answerLotto) {
        int count = 0;
        boolean bonus = false;

        for (Integer numberOfLotto : lotto.getNumbers()) {
            if (matched(numberOfLotto, answerLotto)) {
                count++;
            }
        }
        bonus = matchBonus(lotto, answerLotto.getBonus());
        return matchPrize(count, bonus);
    }
}
