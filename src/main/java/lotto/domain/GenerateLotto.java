package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateLotto {
    private static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConfig.MIN_RANGE, LottoConfig.MAX_RANGE, LottoConfig.LOTTO_SIZE);
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
