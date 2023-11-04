package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public List<Lotto> sellLottos(Integer money) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        validateDividedByPrice(money);

        for (int i = 0; i < money / 1000; i++) {
            List<Integer> lottoNumbers = pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    private void validateDividedByPrice(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000으로 가격이 나누어 떨어져야 합니다.");
        }
    }
}
