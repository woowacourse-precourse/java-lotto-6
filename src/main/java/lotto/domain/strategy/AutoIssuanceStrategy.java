package lotto.domain.strategy;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbersRule;

public class AutoIssuanceStrategy implements IssuableStrategy {

    @Override
    public Lotto issue() {
        return new Lotto(createSortedRandomNumbers());
    }

    private List<Integer> createSortedRandomNumbers() {
        int minNumber = LottoNumbersRule.MIN_NUMBER.value();
        int maxNumber = LottoNumbersRule.MAX_NUMBER.value();
        int lottoNumbersSize = LottoNumbersRule.LOTTO_NUMBERS_SIZE.value();
        return Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, lottoNumbersSize)
                .stream()
                .sorted()
                .toList();
    }

}
