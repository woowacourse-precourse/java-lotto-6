package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final Money money;

    public LottoMachine(String inputMoney) {
        money = new Money(inputMoney);
    }

    /**
     * 입력된 금액만큼 로또 묶음을 생성
     *
     * @return 로또 묶음
     */
    public LottoBundle makeLottoBundle() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.toLottoAmount(); i++) {
            lottos.add(makeLotto());
        }
        return new LottoBundle(lottos);
    }

    private Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
