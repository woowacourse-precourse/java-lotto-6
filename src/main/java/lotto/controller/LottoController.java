package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.handler.UserHandler;

import java.util.List;

public class LottoController {

    int amount = UserHandler.getAmountFromUser();
    int lottoCount = UserHandler.getLottoCountFromUser(amount);

    public void buyLottos() {
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = lottoGenerate();
            System.out.println(lotto.getNumbers());
        }
    }

    private Lotto lottoGenerate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
