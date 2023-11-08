package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.ValidationConstant;

public class LottoMachine {
    public LottoMachine() {
    }

    public Lottos issueLottos(Money money) {
        List<Lotto> issuedLottos = new ArrayList<>();
        for(int i = 0; i < howManyLotto(money); i++) {
            issuedLottos.add(issueLotto());
        }
        return new Lottos(issuedLottos);
    }

    private int howManyLotto(Money money) {
        return money.getMoney() / ValidationConstant.STANDARD_MONEY_UNIT.getNumber();
    }

    private Lotto issueLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                ValidationConstant.MIN_LOTTO_NUMBER.getNumber(),
                ValidationConstant.MAX_LOTTO_NUMBER.getNumber(),
                ValidationConstant.LOTTO_SIZE.getNumber()));
    }
}
