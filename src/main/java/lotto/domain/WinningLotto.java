package lotto.domain;

import java.util.List;
import lotto.exception.DuplicateNumbersException;

public class WinningLotto {

    private final Lotto lotto;
    private final Number bonusNumber;

    private WinningLotto(final Lotto lotto, final Number bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(final List<String> lottoNumbers, final String bonusNumber) {
        validateLottoNumbers(lottoNumbers, bonusNumber);
        return createWinningLotto(lottoNumbers, bonusNumber);
    }

    private static void validateLottoNumbers(final List<String> lottoNumbers, final String bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new DuplicateNumbersException();
        }
    }

    private static WinningLotto createWinningLotto(final List<String> lottoNumbers, final String bonusNumber) {
        Lotto lotto = Lotto.fromStringList(lottoNumbers);
        Number number = Number.from(bonusNumber);
        return new WinningLotto(lotto, number);
    }

    public boolean isMatchBonus(final List<Number> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    public int getSameCount(final List<Number> lottoNumbers) {
        return lotto.getSameCount(lottoNumbers);
    }
}
