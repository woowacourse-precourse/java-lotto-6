package lotto.Util;

import lotto.exception.LottoNumberException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoNumberUtil {

    public List<Integer> convertToNumbers(String lotto){
        return Arrays.stream(lotto.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> validLotto(String lotto){
        LottoNumberException.validateFormat(lotto);
        LottoNumberException.validateNumbersInRangeMaxInt(lotto);
        List<Integer> convertedLotto = convertToNumbers(lotto);
        LottoNumberException.validateNumbersInRange(convertedLotto);
        LottoNumberException.validateNoDuplicates(convertedLotto);
        return convertedLotto;
    }

    public int validBonusNumber(String bonusNumber, List<Integer> lotto){
        LottoNumberException.validateBonusNumberFormat(bonusNumber);
        LottoNumberException.validateBonusNumbersInRangeMaxInt(bonusNumber);
        int bonusNumberDigit = Integer.parseInt(bonusNumber);
        LottoNumberException.validateNumbersInRange(bonusNumberDigit);
        LottoNumberException.validateBonusNumberWithLotto(bonusNumberDigit, lotto);
        return bonusNumberDigit;
    }
}
