package lotto.controller;

import lotto.domain.LottoResultCalculation;
import lotto.type.ResultType;
import org.mockito.internal.matchers.Null;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    public ResultType getRankResult(int sameNumber, boolean isBonus) {
        Optional<ResultType> resultType = Arrays.stream(ResultType.values())
                .filter(result -> result.sameNumber() == sameNumber && result.isBonus() == isBonus)
                .findFirst();
        return resultType.orElse(null);
    }

    public ResultType getTotalResult(List<Integer> target, List<Integer> tryLotto, int bonus) {
        int sameNumber = getLottoResult(target, tryLotto);
        boolean isBonus = getBonusResult(target, bonus);
        ResultType resultType = getRankResult(sameNumber, isBonus);
        return resultType;
    }
}
