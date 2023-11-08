package lotto;

import io.IOHandler;
import lotto.constant.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private final IOHandler ioHandler = new IOHandler();

    public void start() {
        int purchaseAmount = setPurchaseAmount();
        List<Lotto> lottos = Lotto.generateLottos(purchaseAmount);
        ioHandler.printLottos(lottos);

        List<Integer> winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber(winningNumbers);

        Map<LottoRank, Integer> winningHistory = getWinningHistory(lottos, winningNumbers, bonusNumber);
        ioHandler.printWinningHistory(winningHistory);

        double profitRate = calculateProfitRateFromWinningHistory(purchaseAmount, winningHistory);
        ioHandler.printProfitRate(profitRate);
    }

    private int setPurchaseAmount() {
        while (true) {
            try {
                return ioHandler.inputLottoPurchaseAmount();
            } catch (IllegalArgumentException e) {
                ioHandler.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> setWinningNumbers() {
        while (true) {
            try {
                return ioHandler.inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                ioHandler.printErrorMessage(e.getMessage());
            }
        }
    }

    private int setBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                return ioHandler.inputBonusNumber(winningNumbers);
            } catch (IllegalArgumentException e) {
                ioHandler.printErrorMessage(e.getMessage());
            }
        }
    }

    public Map<LottoRank, Integer> getWinningHistory(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        HashMap<LottoRank, Integer> winningHistory = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            winningHistory.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);
            boolean bonusNumberHit = lotto.hasBonusNumber(bonusNumber);
            LottoRank rank = LottoRank.selectRankByMatchCount(matchCount, bonusNumberHit);
            winningHistory.put(rank, winningHistory.get(rank) + 1);
        }

        return winningHistory;
    }

    public double calculateProfitRateFromWinningHistory(int purchaseAmount, Map<LottoRank, Integer> winningHistory) {
        double profit = 0;
        for (LottoRank key : winningHistory.keySet()) {
            profit += winningHistory.get(key) * key.getPrizeMoney();
        }

        return (profit / purchaseAmount) * 100;
    }
}
