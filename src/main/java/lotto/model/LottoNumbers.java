package lotto.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.global.ErrorCode;
import lotto.model.exception.LottoNumbersException;

public class LottoNumbers {

    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public int countMatchNumber(LottoNumbers winningNumbers) {
        int matchCount = 0;
        for (int winningNumber : winningNumbers.getLottoNumbers()) {
            if(isContainNumber(winningNumber)){
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isContainNumber(int number) {
        for (int lottoNumber : lottoNumbers) {
            if (lottoNumber == number) {
                return true;
            }
        }
        return false;
    }

    private void validate(List<Integer> lottoNumbers){
        Map<Integer, Boolean> useLottoNumber = new HashMap<>();
        for (int lottoNumber : lottoNumbers) {
            checkLottoNumberWithinTheRange(lottoNumber);
            checkLottoNumbersDuplicate(useLottoNumber, lottoNumber);
            useLottoNumber.put(lottoNumber, true);
        }
        checkLottoNumbersCount(lottoNumbers);
    }

    private void checkLottoNumberWithinTheRange(int lottoNumber){
        if(lottoNumber < lotto.global.constant.LottoNumber.MIN_LOTTO_NUMBER || lottoNumber > lotto.global.constant.LottoNumber.MAX_LOTTO_NUMBER){
            throw new LottoNumbersException(ErrorCode.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }
    private void checkLottoNumbersCount(List<Integer> lottoNumbers){
        if(lottoNumbers.size() != lotto.global.constant.LottoNumber.LOTTO_NUMBER_COUNT){
            throw new LottoNumbersException(ErrorCode.LOTTO_NUMBER_COUNT_INCORRECT);
        }
    }
    private void checkLottoNumbersDuplicate(Map<Integer, Boolean> useLottoNumber, int number){
        if(useLottoNumber.containsKey(number)){
            throw new LottoNumbersException(ErrorCode.LOTTO_NUMBER_DUPLICATED);
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
