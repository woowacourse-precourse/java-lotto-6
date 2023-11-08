package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoProcess {
    public LottoResult run(List<Lotto> lottos, WinningLotto winningLotto) {
        List<Integer> counted = new ArrayList<>();
        List<Boolean> checked = new ArrayList<>();

        for (Lotto lotto : lottos) {
            counted.add(winningLotto.getLotto().countOverlappingNumbers(lotto));
            checked.add(lotto.isContainBonusNumber(winningLotto.getBonusNumber()));
        }

        return new LottoResult(counted, checked);
    }

    public List<Lotto> buyLotto(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoQuantity; i++) {
            Lotto lotto = new Lotto(NumberGenerator.generate());
            lottos.add(lotto);
        }

        return lottos;
    }
}