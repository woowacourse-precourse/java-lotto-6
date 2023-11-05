package lotto.service;

import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;

public class LottoService {

    public Lottos generateLottos(final PurchaseAmount amount) {
        int lottoCount = amount.toInt() / PurchaseAmount.LOTTO_PRICE;
        return Lottos.from(Stream.generate(this::createLotto)
                .limit(lottoCount)
                .toList()) ;
    }

    private Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
