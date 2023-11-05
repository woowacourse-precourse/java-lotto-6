package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Rule;
import lotto.model.Lotto;

import java.util.List;

public class LottoGenerator implements NumberGenerator<Lotto> {
    @Override
    public Lotto generate() {
        return new Lotto(randomGenerate());
    }

    private List<Integer> randomGenerate() {
        return Randoms.pickUniqueNumbersInRange(Rule.MIN_NUMBER, Rule.MAX_NUMBER, Rule.NUMBER_SIZE);
    }
}
