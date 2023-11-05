package lotto.domain;

import static lotto.Exception.ExceptionMessage.INVALID_BONUS_NUMBER;

import java.util.List;

public class WinningNumber {

    private final List<LottoNumber> WinningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(List<LottoNumber> lottoNumber, LottoNumber bonusNumber) {
        validateContainsBonusNumber(lottoNumber,bonusNumber);
        this.WinningNumbers = lottoNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateContainsBonusNumber(List<LottoNumber> lottoNumber, LottoNumber bonusNumber){
        if(lottoNumber.contains(bonusNumber)){
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER.getExceptionMessage());
        }
    }


}
