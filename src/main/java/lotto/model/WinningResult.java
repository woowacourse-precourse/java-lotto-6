package lotto.model;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.GameConfig;
import lotto.view.OutputView;

public class WinningResult {

    private final Map<LottoRank, Integer> winningResult = new HashMap<>();

    public void addLottoRank(LottoRank lottoRank) {
        int winningResultValue = getWinningResultValue(lottoRank);
        winningResult.put(lottoRank, ++winningResultValue);
    }

    public void displayWinningResult() {
        OutputView.printNewLine();
        OutputView.printWinningResultTitle();

        for (LottoRank lottoRank : LottoRank.getLottoRanksDescendingOrder()) {
            OutputView.printLottoRank(lottoRank, getWinningResultValue(lottoRank));
        }
    }

    public ProfitRate calculateProfitRate() {
        return new ProfitRate(
                calculateTotalWinningMoney(),
                calculateTotalPurchaseAmount());
    }

    private int calculateTotalPurchaseAmount() {
        return winningResult.values().stream()
                .mapToInt(Integer::intValue)
                .sum() * GameConfig.LOTTO_PRICE.getValue();
    }

    private int calculateTotalWinningMoney() {
        return winningResult.keySet().stream()
                .mapToInt(lottoRank -> lottoRank.getWinningMoney() * getWinningResultValue(lottoRank))
                .sum();
    }

    private int getWinningResultValue(LottoRank lottoRank) {
        return winningResult.getOrDefault(lottoRank, GameConfig.ZERO.getValue());
    }
}
