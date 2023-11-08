package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(lottoNumberGenerator);

        int purchaseAmount = lottoPurchase.requestPurchaseAmount();
        List<Lotto> lottoTickets = lottoMachine.issueLottoTickets(purchaseAmount);
        lottoMachine.printLottoTickets(lottoTickets);

        LottoWinningNumberInput lottoWinningNumberInput = new LottoWinningNumberInput();
        Set<Integer> winningNumbers = lottoWinningNumberInput.requestLottoWinningNumbers();
        int bonusNumber = lottoWinningNumberInput.requestBonusNumber(winningNumbers);

        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningNumbers, bonusNumber);
        Map<LottoRank, Integer> rankCount = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            rankCount.put(rank, 0);
        }

        for (Lotto lotto : lottoTickets) {
            Set<Integer> userNumbers = new HashSet<>(lotto.getNumbers());
            LottoResultCalculator.LottoResult result = lottoResultCalculator.calculateResult(userNumbers);
            LottoRank rank = LottoRank.valueOf(result.getMatchCount(), result.isBonusMatch());
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        lottoResultCalculator.printResultSummary(rankCount);

        double yield = LottoResultCalculator.calculateYield(purchaseAmount, rankCount);
        System.out.printf("총 수익률은 %.2f입니다.\n", yield);


    }
}
