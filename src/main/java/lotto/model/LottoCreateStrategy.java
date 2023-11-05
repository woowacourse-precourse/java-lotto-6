package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoCreateStrategy {

    public List<Integer> create(){
        return Randoms.pickUniqueNumbersInRange(LottoNumber.MIN, LottoNumber.MAX, LottoNumber.SIZE);
    }
}
