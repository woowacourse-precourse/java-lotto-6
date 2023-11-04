package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Rule;

import java.util.List;

public class LottoGenerator implements NumberGenerator<List<Integer>> {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Rule.MIN_NUMBER, Rule.MAX_NUMBER, Rule.NUMBER_SIZE);
    }
}
