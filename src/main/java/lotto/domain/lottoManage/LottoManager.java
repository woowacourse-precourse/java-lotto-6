package lotto.domain.lottoManage;

import lotto.config.Prize;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.PlayerLotto;
import lotto.dto.response.PrizeResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    private List<Lotto> winningLottos;
    private PurchaseAmount purchaseAmount;
    private PlayerLotto playerLotto;

    private LottoManager(List<Lotto> winningLottos, PurchaseAmount purchaseAmount, PlayerLotto playerLotto) {
        this.winningLottos = winningLottos;
        this.purchaseAmount = purchaseAmount;
        this.playerLotto = playerLotto;
    }

    public static LottoManager create(List<Lotto> winningLottos, PurchaseAmount purchaseAmount, PlayerLotto playerLotto) {
        return new LottoManager(winningLottos, purchaseAmount, playerLotto);
    }

    private int getPurchasedLottoCount() {
        return purchaseAmount.calculatePurchasedLottoCount();
    }

    public List<PrizeResponse> getWinningResult(PlayerLotto playerLotto) {
        List<Prize> winningPrizes = getWinningPrizes(playerLotto);
        Map<Prize, Integer> winningCounts = getWinningCountForEachPrize(winningPrizes);

        return winningCounts.entrySet().stream()
                .map(winningCount -> PrizeResponse.of(winningCount.getKey(), winningCount.getValue()))
                .toList();
    }

    private Map<Prize, Integer> getWinningCountForEachPrize(List<Prize> winningPrizes) {
        Map<Prize,Integer> winningCounts = new HashMap<>();
        for (Prize winningPrize : winningPrizes) {
            if (Arrays.asList(Prize.values()).contains(winningPrize)) {
                winningCounts.put(winningPrize, winningCounts.getOrDefault(winningPrize, 0) + 1);
            }
        }
        return winningCounts;
    }

    private List<Prize> getWinningPrizes(PlayerLotto playerLotto) {
        List<Prize> prizes = new ArrayList<>();
        for (int i = 0; i < getPurchasedLottoCount(); i++) {
            Lotto winningLotto = winningLottos.get(i);
            int matchingNumberCount = winningLotto.getMatchingNumberCount(playerLotto.getLotto());
            prizes.add(getWinningPrizeForEachLotto(matchingNumberCount, winningLotto.hasBonusNumber(playerLotto.getBonusNumber())));
        }
        return prizes;
    }

    private Prize getWinningPrizeForEachLotto(int matchingNumberCount, boolean hasBonusNumber) {
        if (matchingNumberCount == 5 && hasBonusNumber) {
            return Prize.FIVE_NUMBER_AND_BONUS_NUMBER_MATCH;
        }
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getMatchingNumberCount() == matchingNumberCount)
                .findAny()
                .orElse(Prize.NONE);
    }

    public double calculateProfitRate(List<PrizeResponse> prizeResponses) {
        int totalProfit = 0;
        for (PrizeResponse prizeResponse : prizeResponses) {
            totalProfit += prizeResponse.getPrizeMoney();
        }
        double value = getPercentage(totalProfit);
        return Math.round(value * 100.0) / 100.0;
    }

    private double getPercentage(double totalProfit) {
        return (totalProfit / purchaseAmount.getPrimitivePurchaseAmount()) * 100;
    }
}
