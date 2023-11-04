package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.money.Money;

public class LottoMachine {

    public List<Lotto> purchaseLottos(Money money) {
        int count = money.getAmount() / 1_000;

        return generateLottos(count);
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }
}
