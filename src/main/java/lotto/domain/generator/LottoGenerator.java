package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerator {
    private final static int START_INCLUSIVE = 1;
    private final static int END_INCLUSIVE = 45;
    private final static int COUNT = 6;

    public List<Lotto> issueLotto(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = generateLottoNumber();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
    }
}
