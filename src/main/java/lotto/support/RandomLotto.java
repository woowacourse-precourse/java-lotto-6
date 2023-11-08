package lotto.support;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLotto {

    public List<Lotto> RandomLottos(Long lottoTimes) {
        List<Lotto> lottos = new ArrayList<>();
        for (Long i = 0L; i < lottoTimes; i++) {
            Lotto lotto = new Lotto(getRandomLotto());
            lotto.print();
            lottos.add(lotto);
        }
        return lottos;
    }

    private List<Integer> getRandomLotto() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(new ArrayList<>(numbers));
        return numbers;

    }


}
