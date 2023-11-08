package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_END_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_SIZE;
import static lotto.constant.LottoConstant.LOTTO_START_NUMBER;

import java.util.List;
import java.util.stream.LongStream;

public class LottoMachine {
    private final RandomService randomService;

    public LottoMachine(RandomService randomService) {
        this.randomService = randomService;
    }

    public LottoBundle createLottoBundle(long lottoCnt) {
        List<List<Integer>> lottos = LongStream.range(0, lottoCnt).mapToObj(i -> pickLottoNumbers()).toList();
        return new LottoBundle(lottos);
    }

    private List<Integer> pickLottoNumbers() {
        return randomService.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_SIZE);
    }
}
