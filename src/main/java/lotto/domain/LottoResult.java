package lotto.domain;

import java.util.List;
import lotto.util.Validator;

public class LottoResult {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private LottoResult(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);

        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private LottoResult(List<Integer> winningNumbers, String bonusNumber) {
        this(winningNumbers, Validator.validateNumeric(bonusNumber));
    }

    public static LottoResult create(List<Integer> winningNumber, String bonusNumber) {
        return new LottoResult(winningNumber, bonusNumber);
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        Validator.validateContainsBonusNumber(winningNumbers, bonusNumber);
    }
}
