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
        // TODO: 11/6/23
        ValidateException.hasDuplicateEachNumbers(tempWinNumbers);
        ValidateException.isWinNumbersCountSix(tempWinNumbers);
        ValidateException.checkRangeWinNumbers(tempWinNumbers);

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

    private Integer inputBonusNumber() {
        return Input.InputNumber();
    }

    private List<Integer> inputWinNumbers() {
        return Input.InputNumbers();
    }

    public LottoTargetNumResults giveLottoTargetNumResults() {
        return Config.lottoTargetNumResults(winNumbers, bonusNumber);
    }

}
