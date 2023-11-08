package lotto.domain.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static final int START = 1;
    public static final int END = 45;
    public static final int COUNT = 6;

    public Lottos generate(final long purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>((int) purchaseAmount);
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(generate());
        }
        return new Lottos(lottos);
    }

    /**
     * @return 내부적으로 unmodifiedList인 내림차순 List<Integer>를 갖는 Lotto
     */
    private Lotto generate() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(
                                START,
                                END,
                                COUNT
                        )
                        .stream()
                        .sorted()
                        .toList()
        );
    }
}
