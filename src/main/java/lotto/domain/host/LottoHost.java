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
        // TODO: 11/5/23 입력 체크.
        List<Integer> tempWinNumbers = Input.InputNumbers();

        ValidateException.hasDuplicateEachNumbers(tempWinNumbers);
        ValidateException.isWinNumbersCountSix(tempWinNumbers);
        ValidateException.checkRangeWinNumbers(tempWinNumbers);

        winNumbers = tempWinNumbers;
        return winNumbers;
    }

    public Integer pickBonusNumber() {
        // TODO: 11/5/23 입력 체크.
        Integer tempBonusNumber = inputBonusNumber();

        ValidateException.hasDuplicateNumAndNumbers(tempBonusNumber, winNumbers);

        bonusNumber = tempBonusNumber;
        return bonusNumber;
    }

    // TODO: 11/6/23 예외 처리
    private Integer inputBonusNumber() {
        return Input.InputNumber();
    }


    public LottoTargetNumResults giveLottoTargetNumResults() {
        return Config.lottoTargetNumResults(winNumbers, bonusNumber);
    }

}
