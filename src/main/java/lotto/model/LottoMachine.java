package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.User;

public class LottoMachine {

    public List<Lotto> createLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < User.purchaseCount; i++) {
            lottos.add(createLotto());
        }

        return lottos;
    }

    public Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoNumbers.START_LOTTO_NUMBER,
                LottoNumbers.END_LOTT0_NUMBER, LottoNumbers.COUNT));
    }
}
