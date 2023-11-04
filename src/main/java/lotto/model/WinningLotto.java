package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(List<Integer> lottoNumbers, int bonusLottoNumber) {
        Validation.validateWinningAndBonusNumberDuplication(lottoNumbers, bonusLottoNumber);
        Validation.validateWinningNumberRange(bonusLottoNumber);
        this.lotto = new Lotto(lottoNumbers);
        this.bonusLottoNumber = new LottoNumber(bonusLottoNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusLottoNumber() {
        return bonusLottoNumber;
    }

    public LottoResult compareWithWinningNumbers(List<Integer> lottoNumbers) {

        Set<Integer> lottoNumbersSet = new HashSet<>(lottoNumbers);

        long matchCount = lottoNumbers.stream()
                .filter(lottoNumbersSet::contains)
                .count();

        boolean matchBonus = lottoNumbersSet.contains(bonusLottoNumber);

        return LottoResult.findResult((int) matchCount, matchBonus);
    }
}
