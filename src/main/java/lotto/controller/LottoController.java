package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.handler.UserHandler;
import lotto.view.ResultView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoController {

    int amount = UserHandler.getAmountFromUser();
    int lottoCount = UserHandler.getLottoCountFromUser(amount);

    public void buyLottos() {
        ResultView.printLottoCount(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = lottoGenerate();
            ResultView.printLottoNumber(lotto.getNumbers());
        }
    }

    private Lotto lottoGenerate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
