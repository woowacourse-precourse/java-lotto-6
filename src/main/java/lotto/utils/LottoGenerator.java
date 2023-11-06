package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constants.LottoConstants.*;

public class LottoGenerator {
    public static Lottos generateLottos(long quantity) {
        List<Lotto> lottos = IntStream.iterate(0, i -> i < quantity, i -> i + 1)
                .mapToObj(i -> generateLotto())
                .collect(Collectors.toList());
        return Lottos.create(lottos);
    }

    private static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MINIMUM_RANGE, MAXIMUM_RANGE, NUMBERS_SIZE);
        List<Integer> modifiableNumbers = new ArrayList<>(numbers);
        modifiableNumbers.sort(Comparator.naturalOrder());
        return new Lotto(modifiableNumbers);
    }
}
