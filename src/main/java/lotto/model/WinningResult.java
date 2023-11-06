package lotto.model;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.GameConfig;
import lotto.view.OutputView;

public class WinningResult {

    private final Map<LottoRank, Integer> winningResult = new HashMap<>();

    public WinningResult() {
        initWinningResult();
    }

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

    public void displayProfitRate() {
        ProfitRate profitRate = calculateProfitRate(
                calculateTotalWinningMoney(),
                calculateTotalPurchaseAmount());

        OutputView.printProfitRate(profitRate);
    }

    private ProfitRate calculateProfitRate(int totalWinningMoney, int totalPurchaseAmount) {
        double profitRate = ((double) totalWinningMoney / totalPurchaseAmount) * 100;

        return new ProfitRate(profitRate);
    }

    private int calculateTotalPurchaseAmount() {
        return winningResult.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private int calculateTotalWinningMoney() {
        return winningResult.keySet().stream()
                .mapToInt(lottoRank -> lottoRank.getWinningMoney() * getWinningResultValue(lottoRank))
                .sum();
    }

    private void initWinningResult() {
        for (LottoRank lottoRank : LottoRank.values()) {
            winningResult.put(lottoRank, GameConfig.ZERO.getValue());
        }
    }

    private int getWinningResultValue(LottoRank lottoRank) {
        return winningResult.getOrDefault(lottoRank, GameConfig.ZERO.getValue());
    }
}
