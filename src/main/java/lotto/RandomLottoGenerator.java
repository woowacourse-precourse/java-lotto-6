package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.config.LottoConfig;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public List<Integer> generate() {
        return Stream.generate(() -> Randoms.pickNumberInRange(LottoConfig.MIN_NUMBER, LottoConfig.MAX_NUMBER))
                .distinct()
                .limit(LottoConfig.MAX_BALLS)
                .collect(Collectors.toList());
    }
}
