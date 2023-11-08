package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoVendor;
import lotto.model.MatchResult;
import lotto.model.WinningNumber;

public class LottoService {

    private final LottoVendor lottoVendor;
    private WinningNumber winningNumber;
    private List<Lotto> purchasedLottos;

    public LottoService() {
        this.lottoVendor = new LottoVendor();
    }

    public void generateWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumber = new WinningNumber(winningNumbers, bonusNumber);
    }

    public void purchaseLotto(int purchaseAmount) {
        this.purchasedLottos = lottoVendor.purchaseLotto(BigDecimal.valueOf(purchaseAmount));
    }

    public void matchLottosWithWinningNumbers() {
        for(Lotto lotto : purchasedLottos) {
            MatchResult matchResult = winningNumber.matchLotto(lotto);
            updateWinningCount(matchResult);
        }
    }

    public double calculateProfitRate() {
        BigDecimal totalLottoAmount = lottoVendor.calculateTotalPrice(purchasedLottos.size());
        BigDecimal totalEarnings = calculateTotalProfit();

        return calculateRate(totalEarnings, totalLottoAmount);
    }

    public List<LottoRank> getLottoRanks() {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> !lottoRank.equals(LottoRank.NOTHING))
                .toList();
    }

    public List<List<Integer>> getLottoNumbers() {
        return purchasedLottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    private double calculateRate(BigDecimal totalProfit, BigDecimal totalLottoAmount) {
        if (totalLottoAmount.equals(BigDecimal.ZERO)) {
            return 0.00;
        }
        BigDecimal rate = totalProfit.divide(totalLottoAmount, 3, RoundingMode.HALF_UP);
        return rate.multiply(BigDecimal.valueOf(100)).doubleValue();
    }

    private void updateWinningCount(MatchResult matchingCount) {
        LottoRank.increaseWinningCountByMatchingCount(matchingCount);
    }

    private BigDecimal calculateTotalProfit() {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> !lottoRank.equals(LottoRank.NOTHING))
                .map(rank -> new BigDecimal(rank.getProfit()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
