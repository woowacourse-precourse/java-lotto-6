package lotto.model;

import lotto.exception.Validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(List<LottoNumber> lottoNumbers, LottoNumber bonusLottoNumber) {
        Validation.validateWinningAndBonusNumberDuplication(lottoNumbers, bonusLottoNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public Lotto getLotto() {
        return new Lotto(lottoNumbers);
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
