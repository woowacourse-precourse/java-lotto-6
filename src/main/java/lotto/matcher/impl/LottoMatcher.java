package lotto.matcher.impl;

import lotto.lotto.AnswerLotto;
import lotto.lotto.Lotto;
import lotto.matcher.MatchResult;
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


    @Override
    public MatchResult match(Lotto lotto, AnswerLotto answerLotto) {
        int count = 0;
        boolean bonus = false;

        for (Integer numberOfLotto : lotto.getNumbers()) {
            if (matched(numberOfLotto, answerLotto)) {
                count++;
            }
        }
        bonus = matchBonus(lotto, answerLotto.getBonus());
        return new MatchResult(count, bonus);
    }
}
