package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberCreator {

    public LottoNumberCreator() {}

    public Lottos createLottoNumbers(int number) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < number; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return new Lottos(lottos);
    }

}
