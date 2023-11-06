package lotto.service;

import static lotto.LottoRule.LOTTO_NUMBER_COUNT;
import static lotto.LottoRule.LOTTO_NUMBER_END;
import static lotto.LottoRule.LOTTO_NUMBER_START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {

    private List<Lotto> lottos;

    public void init(int size) {
        this.lottos = new ArrayList<>();
        while (lottos.size() < size) {
            lottos.add(new Lotto(createLottoNumbers()));
        }
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START.value(), LOTTO_NUMBER_END.value(),
                LOTTO_NUMBER_COUNT.value());
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

}
