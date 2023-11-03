package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoPublisher {

    public LottoPublisher() {
    }

    public List<Integer> publishLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
