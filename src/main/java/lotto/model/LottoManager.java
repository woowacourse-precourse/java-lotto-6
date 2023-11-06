package lotto.model;

import java.util.HashMap;
import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoDTO;
import lotto.model.winningLotto.WinningLotto;

public class LottoManager {
    private Lottos lottos;
    private WinningLotto winningLotto;


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
        LottoResult lottoResult = LottoResult.of();
        List<WinningInfo> winningInfos = lottos.toLottoDTOs()
                .stream()
                .map(lottoDTO -> winningLotto.compare(lottoDTO))
                .toList();

        winningInfos.forEach(lottoResult::addResult);
        return lottoResult;
    }


}
