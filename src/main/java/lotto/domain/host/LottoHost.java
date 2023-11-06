package lotto.domain.host;

import lotto.config.Config;
import lotto.domain.num.LottoTargetNumResults;
import lotto.utill.Input;
import lotto.utill.Utii;

import java.util.List;

public class LottoHost {
    private List<Integer> winNumbers;
    private Integer bonusNumber;

    public List<Integer> pickWinNumbers() {
        // TODO: 11/5/23 입력 체크.
        winNumbers = Input.InputNumbers();


        return winNumbers;
    }

    public Integer pickBonusNumber() {
        // TODO: 11/5/23 입력 체크.
        bonusNumber = inputBonusNumber();
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
