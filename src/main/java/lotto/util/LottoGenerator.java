package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class LottoGenerator {
    public static List<Lotto> generateLottos(int gameCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            lottoList.add(generateLotto());
        }
        return lottoList;
    }

    private static Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }
}
