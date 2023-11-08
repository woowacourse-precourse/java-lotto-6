package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoCondition;
import lotto.model.Lottos;

public class LottoService {
    private static final int MIN_NUMBER = LottoCondition.MIN_NUMBER.getNumber();
    private static final int MAX_NUMBER = LottoCondition.MAX_NUMBER.getNumber();
    private static final int COUNT = LottoCondition.COUNT.getNumber();

    public Lottos generateLottos(int lottoCount) {
        Lottos lottos = new Lottos();
        for(int i = 0; i < lottoCount; i++) {
            Lotto lotto = generateLotto();
            lottos.addLotto(lotto);
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                                                    MIN_NUMBER,
                                                    MAX_NUMBER,
                                                    COUNT));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
