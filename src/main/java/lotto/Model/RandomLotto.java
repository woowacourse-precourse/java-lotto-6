package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomLotto {
    private int count;

    public RandomLotto(Price price) {
        count = price.divideWithOneThousands();
    }

    public int getCount() {
        return count;
    }

    public int minusCount() {
        return count--;
    }

    public Lotto createRandomLottos() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
