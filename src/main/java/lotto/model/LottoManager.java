package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoDTO;
import lotto.model.winningLotto.WinningLotto;

public class LottoManager {
    private Lottos lottos;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;


    public void makeLottos(int numberOfLottos, LottoGenerator lottoGenerator) {
        lottos = Lottos.of(numberOfLottos, lottoGenerator);
    }

    public void makeWinningLotto(Lotto lotto, int bonusNumber) {
        winningLotto = WinningLotto.of(lotto, bonusNumber);
    }

    public List<List<Integer>> getPurchaseLottos() {
        return lottos.toLottoDTOs()
                .stream()
                .map(LottoDTO::numbers)
                .toList();
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

        double winningAmount = winningInfos.stream()
                .mapToDouble(winningInfo -> winningInfo.price * lottoResult.getCount(winningInfo))
                .sum();


        return winningAmount / purchaseAmount;
    }
}
