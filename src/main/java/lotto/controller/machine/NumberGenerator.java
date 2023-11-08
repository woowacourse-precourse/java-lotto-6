package lotto.controller.machine;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoRule;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private List<Integer> createUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoRule.MIN_NUMBER.getValue(),
                LottoRule.MAX_NUMBER.getValue(),
                LottoRule.NUMBER_COUNT.getValue());
    }

    public Lotto createLotto() {
        List<Integer> lottoNumber;
        Lotto lotto;

        while (true) {
            try {
                lottoNumber = createUniqueNumbers();
                lotto = new Lotto(lottoNumber);
            } catch (IllegalArgumentException exception) {
                continue;
            }

            break;
        }

        return lotto;
    }

    public List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto;

        for (int i = 0; i < count; i++) {
            lotto = createLotto();
            lottos.add(lotto);
        }

        return lottos;
    }
}
