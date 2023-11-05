package lotto.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;


public class LottoMaker {
    public List<Integer> getLotto() { // 로또 만들기
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
