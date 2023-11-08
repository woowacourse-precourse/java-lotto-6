package lotto.matcher;

import lotto.config.LottoPrize;
import lotto.lotto.AnswerLotto;
import lotto.lotto.Lotto;

public interface Matcher {
    public LottoPrize match(Lotto lotto, AnswerLotto answerLotto);
}
