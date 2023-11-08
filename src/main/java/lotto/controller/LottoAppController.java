package lotto.controller;

import lotto.constant.LottoResult;
import lotto.model.*;

import java.util.List;

public class LottoAppController {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public List<Lotto> purchaseLottos(Budget budget) {
        int lottoAmount = budget.getLottoAmount();
        lottoGenerator.generate(lottoAmount);

        return lottoGenerator.getLottos();
    }

    public TotalResult processLottoResult(WinningLotto win, List<Lotto> lottos) {
        TotalResult totalResult = new TotalResult();
        for (Lotto lotto : lottos) {
            LottoResult result = win.getLottoResult(lotto);
            if (result != null) {
                totalResult.add(result);
            }
        }

        return totalResult;
    }

    public ProfitStats createProfitStats(Budget budget, TotalResult totalResult) {
        int totalProfit = 0;
        for (LottoResult type : LottoResult.values()) {
            totalProfit += type.multiplePrize(totalResult.get(type));
        }
        double rate = (double) (totalProfit) / budget.getBudget() * 100;

        return new ProfitStats(totalProfit, rate);
    }
}
