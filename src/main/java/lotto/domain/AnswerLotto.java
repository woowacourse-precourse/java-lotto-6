package lotto.domain;

import static lotto.domain.exception.DomainExceptionCode.ANSWER_LOTTO_AND_BONUS_NUMBER_DUPLICATE;
import static lotto.domain.exception.DomainExceptionCode.BONUS_NUMBER_MUST_BE_REQUIRED;

import java.util.List;
import java.util.Objects;

public class AnswerLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber; // nullable

    private AnswerLotto(Lotto lotto) {
        this.lotto = lotto;
        this.bonusNumber = null;
    }

    private AnswerLotto(Lotto lotto, BonusNumber bonusNumber) {
        ANSWER_LOTTO_AND_BONUS_NUMBER_DUPLICATE.dynamicInvokeBy(() -> lotto.contains(bonusNumber.value()));

        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static AnswerLotto of(List<Integer> numbers) {
        return new AnswerLotto(new Lotto(numbers));
    }

    public AnswerLotto registerBonusNumber(Integer number) {
        return new AnswerLotto(this.lotto, new BonusNumber(number));
    }

    public MatchResult match(Lotto otherLotto) {
        BONUS_NUMBER_MUST_BE_REQUIRED.dynamicInvokeBy(() -> Objects.isNull(bonusNumber));

        return new MatchResult(
                lotto.matchCount(otherLotto),
                otherLotto.contains(bonusNumber.value())
        );
    }

}
