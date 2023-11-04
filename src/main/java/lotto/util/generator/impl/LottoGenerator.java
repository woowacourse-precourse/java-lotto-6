package lotto.util.generator.impl;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.util.generator.Generator;

public class LottoGenerator implements Generator {

    @Override
    public List<Lotto> generate(int lottoCount) {
        return IntStream.range(0, lottoCount)
            .mapToObj(i -> new Lotto(generateLotto()))
            .collect(Collectors.toList());
    }

    public List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
