package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class UserLottoController {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public List<Lotto> buyLotto(int amount) {
        int lottoCount = amount / LOTTO_PRICE;

        final List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lotto.add(getNewLotto());
        }
        return lotto;
    }

    public Lotto getNewLotto() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, MAX_SIZE)
        );
    }
}
