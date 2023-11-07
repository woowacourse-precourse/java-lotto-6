package lotto.controller;

import lotto.domain.LottoResultCalculation;
import lotto.type.ResultType;
import org.mockito.internal.matchers.Null;

import java.util.List;

public class ResultController {
    LottoResultCalculation lottoResultCalculation;

    ResultController() {
        lottoResultCalculation = new LottoResultCalculation();
    }

    public int getLottoResult(List<Integer> target, List<Integer> tryLotto) {
        int result = lottoResultCalculation.checkResult(target, tryLotto);
        return result;
    }

    public boolean getBonusResult(List<Integer> target, int bouns) {
        boolean result = lottoResultCalculation.checkBonusNumber(target, bouns);
        return result;
    }

    public ResultType getLottoResult(int sameNumber, boolean isBonus) {
        if (sameNumber == 3) {
            return ResultType.THIRD;
        }
        if (sameNumber == 4) {
            return ResultType.FOURTH;
        }
        if (sameNumber == 5) {
            if (isBonus) {
                return ResultType.FIFTH_BONUS;
            }
        }
        if (sameNumber == 6) {
            return ResultType.ALL;
        }
        return null;
    }

    public ResultType getTotalResult(List<Integer> target, List<Integer> tryLotto, int bonus) {
        int sameNumber = getLottoResult(target, tryLotto);
        boolean isBonus = getBonusResult(target, bonus);
        ResultType resultType = getLottoResult(sameNumber, isBonus);
        return resultType;
    }
}
