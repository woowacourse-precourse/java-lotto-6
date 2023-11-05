package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    public Lotto generate() {
        return new Lotto(generateRandomLottoNumbers());
    }

    private List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                        LottoNumber.MIN.getNumber(),
                        LottoNumber.MAX.getNumber(),
                        LottoNumber.COUNT.getNumber()
                )
                .stream()
                .toList();
    }
}
