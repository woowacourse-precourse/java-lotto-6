package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {

    public List<Lotto> issueLottos(int num) {

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < num / 1000; i++) {
            List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(pickedNumbers));
        }

        return lottos;
    }
}
