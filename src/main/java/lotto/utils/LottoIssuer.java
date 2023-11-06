package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Stream;

public class LottoIssuer {

    private LottoIssuer() {
    }

    public static List<Lotto> issue(int issuesNumber) {
        return Stream.generate(LottoIssuer::issue)
                .distinct()
                .limit(issuesNumber)
                .toList();
    }

    private static Lotto issue() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }
}
