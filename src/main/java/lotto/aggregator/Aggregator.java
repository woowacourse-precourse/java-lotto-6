package lotto.aggregator;

import java.util.List;
import lotto.lotto.AnswerLotto;
import lotto.lotto.Lotto;

public interface Aggregator {
    public void aggregate(List<Lotto> results, AnswerLotto answerLotto);
}
