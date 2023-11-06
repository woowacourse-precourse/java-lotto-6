package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoVendor {
    public List<Lotto> generateLottos(Integer purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        Integer remainingLottos = purchaseAmount / 1000;

        while (remainingLottos > 0) {
            lottos.add(generateLotto());
            remainingLottos--;
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }
}
