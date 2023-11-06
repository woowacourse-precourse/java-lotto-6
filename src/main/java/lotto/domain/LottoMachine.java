package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private final Money money;

    public LottoMachine(String inputMoney) {
        money = new Money(inputMoney);
    }

    public LottoBundle makeLottoBundle() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.toLottoAmount(); i++) {
            lottos.add(makeLotto());
        }
        return new LottoBundle(lottos);
    }

    private Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
