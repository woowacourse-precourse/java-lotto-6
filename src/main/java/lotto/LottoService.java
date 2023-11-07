package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private int getNumberOfLotto(int price) {
        return price / 1000;
    }

    public List<Lotto> createLotto(int price) {
        List<Lotto> lottos = new ArrayList<>();
        int number = getNumberOfLotto(price);

        for (int i = 0; i < number; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lottos;
    }
}
