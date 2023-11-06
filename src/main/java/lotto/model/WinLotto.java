package lotto.model;

import java.util.List;

public class WinLotto {
    private static final String ALREADY_CONTAIN_BONUS_NUMBER_IN_NUMBERS_ERROR = "보너스 번호가 당첨 번호와 중복되면 안됩니다.";

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateDuplicateBonusNumber(lotto.getNumbers(), bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private static void validateDuplicateBonusNumber(List<LottoNumber> winNumbers, LottoNumber bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ALREADY_CONTAIN_BONUS_NUMBER_IN_NUMBERS_ERROR);
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
