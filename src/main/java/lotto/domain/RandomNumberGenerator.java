package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    private final List<Lotto> lottoList = new ArrayList<>();

    public void lottoNumbers(int numOfLottos) {
        for (int i = 0; i < numOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
    }

    public List<Lotto> getLotteries() {
        return Collections.unmodifiableList(lottoList);
    }
}
