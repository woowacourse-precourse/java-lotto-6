package lotto.userLotto.service;

import static lotto.util.LottoConstant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.userLotto.domain.Lotto;
import lotto.userLotto.domain.Lottos;

public class LottoService {


    public Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(BEGIN_NUMBER, LAST_NUMBER, LOTTO_SIZE));
    }

    public Lottos createLottos(int count) {
        List<Lotto> arr = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            arr.add(createLotto());
        }
        return new Lottos(arr);
    }
}
