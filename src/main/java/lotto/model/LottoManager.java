package lotto.model;

import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoDTO;

public class LottoManager {
    private Lottos lottos;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;


    public void createLottos(int numberOfLottos, LottoGenerator lottoGenerator) {
        lottos = Lottos.of(numberOfLottos, lottoGenerator);
    }

    public void createWinningLotto(Lotto lotto, int bonusNumber) {
        winningLotto = WinningLotto.of(lotto, bonusNumber);
    }

    public List<String> getPurchaseLottos() {
        return lottos.getPurchaseLottos();
    }

    public LottoResult calculateLottoResult() {
        lottoResult = LottoResult.of();
        List<WinningInfo> winningInfos = lottos.getWinnningInfos(winningLotto);
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
