package lotto.service;

import static lotto.LottoConstants.LOTTO_SIZE;
import static lotto.LottoConstants.NUMBER_HIGH_BOUND;
import static lotto.LottoConstants.NUMBER_LOW_BOUND;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.LongStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

public class LottoService {
    public Lottos generateAutoLottos(long count) {
        List<Lotto> lottos = LongStream.range(0, count)
                .mapToObj(generateCount -> generategenerateAutoLotto())
                .toList();

        return toLottos(lottos);
    }

    private Lotto generategenerateAutoLotto() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange((int) NUMBER_LOW_BOUND.getValue(), (int) NUMBER_HIGH_BOUND.getValue(),
                        (int) LOTTO_SIZE.getValue()));
    }

    private Lottos toLottos(List<Lotto> lottos) {
        return new Lottos(lottos);
    }


    public Lotto generateManualLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public LottoNumber generateLottoNumber(long number) {
        return new LottoNumber(number);
    }
}
