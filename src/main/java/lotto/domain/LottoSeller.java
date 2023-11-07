package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
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
        int start = Value.START_NUMBER.get();
        int end = Value.END_NUMBER.get();
        int count = Value.LOTTO_NUMBER_COUNT.get();
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(start, end, count));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}