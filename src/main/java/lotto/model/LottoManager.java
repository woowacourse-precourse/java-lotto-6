package lotto.model;

import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoDTO;
import lotto.model.winningLotto.WinningLotto;
import lotto.model.winningLotto.WinningLottoDTO;

public class LottoManager {
    private Lottos lottos;

    public void makeLottos(int numberOfLottos, LottoGenerator lottoGenerator) {
         lottos = Lottos.of(numberOfLottos, lottoGenerator);
    }

    public List<List<Integer>> getPurchaseLottos(){
        return lottos.toSortedLottoDTOs()
                .stream()
                .map(LottoDTO::numbers)
                .toList();
    }

}
