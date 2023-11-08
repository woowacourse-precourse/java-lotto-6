package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constant.GameConstant;

public class LottoGenerator {
    public List<Lotto> makeLotto(int count){
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(GameConstant.NUMBER_MIN,
                                GameConstant.NUMBER_MAX, GameConstant.NUMBER_SIZE)
                        .stream().sorted().collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
}
