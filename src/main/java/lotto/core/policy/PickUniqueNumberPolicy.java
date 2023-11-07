package lotto.core.policy;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.property.LottoProperty.*;

public class PickUniqueNumberPolicy implements PickNumberPolicy {
    @Override
    public List<Integer> pickUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START, LOTTO_END, WINNING_SIZE);
    }
}
