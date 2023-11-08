package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Strategy {

    public static List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(LottoNumber.MIN, LottoNumber.MAX, Lotto.SIZE);
    }
}
