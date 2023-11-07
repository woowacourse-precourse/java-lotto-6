package lotto.controller;

import lotto.domain.LottoResultCalculation;

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
        boolean result = lottoResultCalculation.checkBounsNumber(target, bouns);
        return result;
    }
}
