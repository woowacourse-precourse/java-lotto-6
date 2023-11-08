package lotto.service;

import java.util.List;
import lotto.domain.LottoMachine;
import lotto.domain.Result;
import lotto.domain.WinningCondition;
import lotto.dto.LottoCompareResult;

public class LottoService {
    public Result calculateResult(LottoMachine lottoMachine, WinningCondition winningCondition) {
        List<LottoCompareResult> lottoCompareResultList = calculateLottoCompareResults(lottoMachine, winningCondition);

        Result result = new Result();
        result.calculateTotalWinningMoney(lottoCompareResultList);
        result.calculateProfitRate(lottoMachine.getInputAmount());

        return result;
    }

    private List<LottoCompareResult> calculateLottoCompareResults(LottoMachine lottoMachine,
                                                                  WinningCondition winningCondition) {
        return lottoMachine.getLottos().stream()
                .map(winningCondition::compare)
                .toList();
    }
}
