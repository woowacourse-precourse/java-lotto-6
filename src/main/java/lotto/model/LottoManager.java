package lotto.model;

import java.util.List;

public class LottoManager {
    private PurchasedLottos purchasedLottos;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;


    public void createLottos(int numberOfLottos, LottoGenerator lottoGenerator) {
        purchasedLottos = PurchasedLottos.of(numberOfLottos, lottoGenerator);
    }

    public void createWinningLotto(Lotto lotto, int bonusNumber) {
        winningLotto = WinningLotto.of(lotto, bonusNumber);
    }

    public List<String> getPurchaseLottos() {
        return purchasedLottos.getPurchaseLottos();
    }

    public LottoResult calculateLottoResult() {
        lottoResult = LottoResult.of();
        List<WinningInfo> winningInfos = purchasedLottos.getWinnningInfos(winningLotto);
        winningInfos.forEach(lottoResult::addResult);
        return lottoResult;
    }


    public double calculateRateOfReturn(int purchaseAmount) {
        List<WinningInfo> winningInfos = List.of(WinningInfo.THREE_MATCH, WinningInfo.FOUR_MATCH,
                WinningInfo.FIVE_MATCH,
                WinningInfo.FIVE_AND_BONUS_MATCH, WinningInfo.SIX_MATCH);

        double totalWinningAmount = sumWinningAmount(winningInfos);

        return totalWinningAmount / purchaseAmount;
    }

    private double sumWinningAmount(List<WinningInfo> winningInfos) {
        return winningInfos.stream()
                .mapToDouble(winningInfo -> lottoResult.calculateWinningAmount(winningInfo))
                .sum();
    }
}
