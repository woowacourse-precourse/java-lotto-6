package lotto.Domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGroup {

    private final Set<Lotto> lottoGroup;
    private static final Integer LOTTO_PRICE = 1000;

    private LottoGroup(Money money) {
        this.lottoGroup = new HashSet<>();
        Integer lottoCount = findLottoCount(money);
        for (int i = 0; i < lottoCount; i++) {
            this.lottoGroup.add(Lotto.from(generateLottoNumbers()));
        }
    }

    public static LottoGroup from(Money money) {
        return new LottoGroup(money);
    }

    private Integer findLottoCount(Money money) {
        return money.getMoney()/LOTTO_PRICE;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}