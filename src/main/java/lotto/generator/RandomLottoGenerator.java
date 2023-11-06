package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.Lotto;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConstant.LOTTO_START_NUMBER,
                LottoConstant.LOTTO_END_NUMBER,
                LottoConstant.LOTTO_NUMBER_COUNT);

        ArrayList<Integer> numbersToSort = new ArrayList<>(numbers);
        Collections.sort(numbersToSort);

        return new Lotto(numbersToSort);
    }
}