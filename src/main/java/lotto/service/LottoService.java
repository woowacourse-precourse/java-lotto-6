package lotto.service;

import static lotto.LottoConstants.LOTTO_SIZE;
import static lotto.LottoConstants.NUMBER_HIGH_BOUND;
import static lotto.LottoConstants.NUMBER_LOW_BOUND;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.LongStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoService {
    public List<Lotto> generateAutoLottos(long count) {
        return LongStream.range(0, count)
                .mapToObj(generateCount -> new Lotto(
                        Randoms.pickUniqueNumbersInRange((int) NUMBER_LOW_BOUND.getValue(),
                                (int) NUMBER_HIGH_BOUND.getValue(),
                                (int) LOTTO_SIZE.getValue())))
                .toList();
    }

    public Lotto generateManualLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public LottoNumber generateLottoNumber(long number) {
        return new LottoNumber(number);
    }

}
