package lotto.domain;

import java.util.List;
import lotto.validation.Validation;
import lotto.validation.winningnumber.WinningLottoDuplicateCondition;

public class WinningLotto {
    private static final Integer WINNING_LOTTO_SIZE = 7;
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;
    private static final Validation domainValidation;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    static {
        domainValidation = new Validation(
                new WinningLottoDuplicateCondition(WINNING_LOTTO_SIZE)
        );
    }

    private void validate(Lotto winningLotto, BonusNumber bonusNumber) {
        List<Integer> lottoNumber = winningLotto.getNumbers();
        Integer bonusNum = bonusNumber.getBonusNumber();
        lottoNumber.add(bonusNum);

        domainValidation.validate(lottoNumber);
    }

}
