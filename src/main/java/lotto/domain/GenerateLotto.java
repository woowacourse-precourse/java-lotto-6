package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateLotto {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int COUNT = 6;

    private static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, COUNT);
    }

    private static List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Lotto> generateLottoGroup(int LottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < LottoCount) {
            lottos.add(new Lotto(sorted(generateLottoNumbers())));
        }

        return lottos;
    }
}
