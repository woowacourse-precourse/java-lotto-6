package lotto.domain;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConfig;
import lotto.constant.Value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoSeller {

    public static LottoSeller create() {
        return new LottoSeller();
    }

    public List<Lotto> sellLottos(int money) {
        int count = money / Value.THOUSAND.get();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(issueLotto());
        }
        return lottos;
    }

    Lotto issueLotto() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < LottoConfig.LOTTO_NUMBER_COUNT.get()) {
            int picked = Randoms.pickNumberInRange(LottoConfig.START_NUMBER.get(), LottoConfig.END_NUMBER.get());
            if (!numbers.contains(picked)) {
                numbers.add(picked);
            }
        }
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}