package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class LottoIssuer {

    private LottoIssuer() {
    }

    public static List<Lotto> issue(int issuesNumber) {
        return IntStream.rangeClosed(1, issuesNumber)
                .mapToObj(count -> issue())
                .toList();
    }

    private static Lotto issue() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }
}
