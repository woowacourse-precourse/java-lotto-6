package lotto.matcher;

import lotto.lotto.AnswerLotto;
import lotto.lotto.Lotto;

public interface Matcher {
    public MatchResult match(Lotto lotto, AnswerLotto answerLotto);
}
