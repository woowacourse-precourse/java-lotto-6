package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator implements NumberGenerator<List<Integer>> {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
