package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerateLotto {
    public List<Lotto> getLottoNumbers(int count) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < count) {
            lottos.add(generateLotto());
        }

        return lottos;

    }
    private List<Integer> generateLottoNumbers() {
         return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private Lotto generateLotto() {
        return new Lotto(generateLottoNumbers());
    }
}
