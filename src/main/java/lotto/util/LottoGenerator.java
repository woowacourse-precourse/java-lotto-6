package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.validator.Validator;

public class LottoGenerator  {

    public List<Lotto> generate(int lottoCount){
        return IntStream.range(0, lottoCount)
            .mapToObj(i -> new Lotto(generateLotto()))
            .collect(Collectors.toList());
    }

    public List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
            .stream().sorted()
            .collect(Collectors.toList());
    }

}
