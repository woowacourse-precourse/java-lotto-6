package lotto.domain.host;

import Validate.ValidateException;
import lotto.config.Config;
import lotto.domain.num.LottoTargetNumResults;
import lotto.utill.Input;

import java.util.List;

public class LottoHost {
    private List<Integer> winNumbers;
    private Integer bonusNumber;

    public List<Integer> pickWinNumbers() {
        List<Integer> tempWinNumbers = inputWinNumbers();

        validateInputWinNumbers(tempWinNumbers);

        winNumbers = tempWinNumbers;
        return winNumbers;
    }


    public Integer pickBonusNumber() {
        Integer tempBonusNumber = inputBonusNumber();

        ValidateException.hasDuplicateNumAndNumbers(tempBonusNumber, winNumbers);
        ValidateException.isInRangeBonusNumber(tempBonusNumber);

        bonusNumber = tempBonusNumber;
        return bonusNumber;
    }

    public LottoTargetNumResults giveLottoTargetNumResults() {
        return Config.lottoTargetNumResults(winNumbers, bonusNumber);
    

    }

    private void validateInputWinNumbers(List<Integer> tempWinNumbers) {
        ValidateException.hasDuplicateEachNumbers(tempWinNumbers);
        ValidateException.isWinNumbersCountSix(tempWinNumbers);
        ValidateException.checkRangeWinNumbers(tempWinNumbers);
    }

    private Integer inputBonusNumber() {
        return Input.InputNumber();
    }

    private List<Integer> inputWinNumbers() {
        return Input.InputNumbers();
    }

}
