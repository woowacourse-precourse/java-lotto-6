package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.config.LottoConfig;

public class RandomLottoMachine implements LottoMachine {

    @Override
    public List<Lotto> generateLottos(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj((lottoOrder) -> generateLotto())
                .collect(Collectors.toList());
    }

    private Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>(pickRandomLottoNumbers());
        Collections.sort(numbers);
        return Lotto.from(numbers);
    }

    private List<Integer> pickRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConfig.MIN_LOTTO_NUMBER, LottoConfig.MAX_LOTTO_NUMBER,
                LottoConfig.LOTTO_NUMBER_COUNT);
    }
}
