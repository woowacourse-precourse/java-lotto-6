package lotto.domain.lotto;

import lotto.global.constant.BonusNumberMatch;
import lotto.global.converter.NumberConverter;

import java.util.List;

public class BonusNumber {
    private WinningNumber bonusNumber;

    public void generateBonusNumber(String inputNumber) {
        Integer number = NumberConverter.convertToNumber(inputNumber);
        bonusNumber = new WinningNumber(number);
    }

    public BonusNumberMatch compareBonusNumberWithLotto(Lotto lotto, int matchCount) {
        if(matchCount != 5) {
            return BonusNumberMatch.NOT_MATTER;
        }
        List<Integer> lottoNumbers = lotto.getNumbers();

        for (Integer lottoNumber : lottoNumbers) {
            if(bonusNumber.isEqualsToLottoNumber(lottoNumber) ) {
                return BonusNumberMatch.MATCH;
            }
        }
        return BonusNumberMatch.NOT_MATCH;
    }

    public WinningNumber getBonusNumber() {
        return bonusNumber;
    }


}
