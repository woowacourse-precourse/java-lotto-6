package lotto.domain;

import java.util.List;

public record PurchasedLottoBundle(List<Lotto> value) {
    public List<MatchResult> checkResult(AnswerLotto answerLotto) {
        return value.stream().map(answerLotto::match)
                .toList();
    }
}
