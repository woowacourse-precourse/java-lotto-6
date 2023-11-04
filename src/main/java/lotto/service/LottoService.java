package lotto.service;

import lotto.constants.Value;
import lotto.domain.Lotto;
import lotto.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {

    RandomUtils randomUtils = new RandomUtils();

    public List<Lotto> createUserLottos(int lottoCount) {
        return IntStream.range(0, lottoCount / Value.LOTTO_TICKET_PRICE)
                .mapToObj(i -> createSingleLotto())
                .collect(Collectors.toList());
    }

    private Lotto createSingleLotto() {
        return new Lotto(randomUtils.sixUniqueRandomNumber());
    }

}
