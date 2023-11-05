package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinnerLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public Money putMoney() {
        return InputView.inputMoney();
    }

    public Lottos buyLottos(Money money) {
        int buyLottoCount = money.getBuyLottoCount();
        OutputView.outputBuyLottoCount(buyLottoCount);
        return makeLottos(buyLottoCount);
    }

    private Lottos makeLottos(int buyLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        while(buyLottoCount > 0) {
            lottos.add(makeLotto());
            buyLottoCount--;
        }
        return Lottos.from(lottos);
    }

    private Lotto makeLotto() {
        List<Integer> uniqueRandomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(uniqueRandomNumbers);
        OutputView.outputLottoNumbers(lotto);
        return lotto;
    }

    public WinnerLotto putWinnerLotto() {
        return InputView.inputWinnerLotto();
    }

}
