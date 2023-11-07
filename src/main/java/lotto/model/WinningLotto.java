package lotto.model;

import java.util.List;
import lotto.util.ErrorMessage;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;

        validateBonusNumber(bonusNumber.getBonusNumber());
        this.bonusNumber = bonusNumber;
    }

    public int calculateMatchNumber(LottoPlayerNumber lottoPlayerNumber) {
        List<Integer> numbers = lotto.getNumbers();

        return (int) lottoPlayerNumber.getLottoPlayerNumber()
                .stream()
                .filter(numbers::contains)
                .count();

    }

    public boolean hasBonusNumber(LottoPlayerNumber lottoPlayerNumber) {
        return lottoPlayerNumber.getLottoPlayerNumber()
                .contains(bonusNumber.getBonusNumber());
    }

    private void validateBonusNumber(int bonusNumber) {
        validateBonusNumberDuplicate(bonusNumber);
    }

    private void validateBonusNumberDuplicate(int bonusNumber) {
        if (isContain(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    private boolean isContain(int bonusNumber) {
        return lotto.getNumbers()
                .contains(bonusNumber);
    }
}
