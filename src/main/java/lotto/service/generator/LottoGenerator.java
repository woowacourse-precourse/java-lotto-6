package lotto.service.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.Lottos;

public class LottoGenerator {

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
                                Lotto.START,
                                Lotto.END,
                                Lotto.COUNT
                        )
                        .stream()
                        .sorted()
                        .toList()
        );
    }
}
