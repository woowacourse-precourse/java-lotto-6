package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public enum LottoGenerator {
    INSTANCE;
    private final int BOTTOM_RANGE=1;
    private final int TOP_RANGE=45;

    public List<Lotto> generate(int count){
        return IntStream.range(0,count)
                .mapToObj(generateCount->new Lotto(Randoms.pickUniqueNumbersInRange(BOTTOM_RANGE,TOP_RANGE,6)))
                .toList();
    }
}
