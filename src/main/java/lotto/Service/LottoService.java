package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.domain.LottoServiceEnum.*;

public class LottoService {

    public List<Lotto> createLotto(Integer price) {

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < price; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    public Lotto createLotto() {
        List<Integer> random = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                START_INCLUSIVE.getCreateLotto(), END_INCLUSIVE.getCreateLotto(), COUNT.getCreateLotto()));
        return getLotto(random);
    }

    public Lotto getLotto(List<Integer> random) {
        random.sort(Comparator.naturalOrder());
        return new Lotto(random);
    }
}
