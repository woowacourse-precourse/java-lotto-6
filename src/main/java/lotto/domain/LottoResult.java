package lotto.domain;

import java.util.List;
import lotto.util.Validator;

public class LottoResult {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private LottoResult(List<Integer> winningNumber, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private LottoResult(List<Integer> winningNumber, String bonusNumber) {
        this(winningNumber, Validator.validateNumeric(bonusNumber));
    }

    public static LottoResult create(List<Integer> winningNumber, String bonusNumber) {
        return new LottoResult(winningNumber, bonusNumber);
    }
}
