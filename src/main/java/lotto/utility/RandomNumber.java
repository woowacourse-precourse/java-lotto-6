package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumber {

    public List<Integer> makeLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
