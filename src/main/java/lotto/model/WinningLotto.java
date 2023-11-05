package lotto.model;

import lotto.exception.Validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public LottoResult compareWithWinningNumbers(List<LottoNumber> lottoNumbers) {

        Set<Integer> lottoNumbersSet = lottoNumbers.stream()
                .map(LottoNumber::getWinningNumber)
                .collect(Collectors.toSet());

        long matchCount = lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumbersSet.contains(lottoNumber.getWinningNumber()))
                .count();

        boolean matchBonus = lottoNumbersSet.contains(bonusLottoNumber.getWinningNumber());

        return LottoResult.findResult((int) matchCount, matchBonus);
    }
}
