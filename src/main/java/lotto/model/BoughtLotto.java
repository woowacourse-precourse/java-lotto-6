package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.ConstantNumber;

public class BoughtLotto {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final int boughtNumber;
    private final List<Lotto> lottos = new ArrayList<>();

    public BoughtLotto(int price) {
        this.boughtNumber = price / ConstantNumber.THOUSAND;
        for (int i = 0; i < boughtNumber; i++) {
            lottos.add(createLotto());
        }
    }

    public List<Lotto> getAllLotto() {
        return lottos;
    }

    public int getBoughtNumber() {
        return boughtNumber;
    }

    private static Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN, MAX, ConstantNumber.PROPER_LOTTO_LENGTH));
    }
}
