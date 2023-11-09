package lotto.util.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumbersGeneratorImpl implements LottoNumbersGenerator {
    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
