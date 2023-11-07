package lotto.model;

import static lotto.model.calculator.MatchCalculator.calculateMatches;
import static lotto.model.calculator.ProfitCalculator.calculateProfitPercentage;
import static lotto.model.calculator.ProfitCalculator.calculateProfitPrice;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.result.CalculateResult;
import lotto.domain.result.MatchResult;
import lotto.domain.result.PurchaseResult;
import lotto.domain.result.WinningResult;
import lotto.domain.Purchase;
import lotto.domain.strategy.LottoStrategy;
import lotto.domain.strategy.RandomLottoStrategy;

public class Model {
    private final LottoStrategy lottoStrategy = new RandomLottoStrategy();

    public List<Lotto> generateLottos(Purchase purchase) {
        int finalRound = purchase.getFinalRound();
        List<Lotto> lottos = new ArrayList<>();

        for (int round = 0; round < finalRound; round++) {
           Lotto lotto = new Lotto(lottoStrategy.generateNumbers());
           lottos.add(lotto);
        }
        return lottos;
    }

    public MatchResult calculateMatch(PurchaseResult purchaseResult, WinningResult winningResult) {
        List<Lotto> lottos = purchaseResult.getLottos();
        return calculateMatches(lottos, winningResult);
    }

    public CalculateResult calculateProfit(MatchResult matchResult, PurchaseResult purchaseResult) {
        int totalProfit = calculateProfitPrice(matchResult);
        int purchasePrice = purchaseResult.getPurchase().getPurchasePrice();
        float profitMargin = calculateProfitPercentage(totalProfit, purchasePrice);

        return new CalculateResult(totalProfit, profitMargin);
    }
}
