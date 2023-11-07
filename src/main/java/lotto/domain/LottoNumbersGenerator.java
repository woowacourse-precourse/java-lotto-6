package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumbersGenerator implements NumberGenerator<List<Integer>>{

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER, Lotto.LOTTO_NUMBER_SIZE
        );
    }
}
