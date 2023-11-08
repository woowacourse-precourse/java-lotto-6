package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.Constant;
import lotto.validation.Validator;

public class LottoMachine {

    public final List<Lotto> issueLottos(int purchaseAmount) {
        Validator.validatePurchaseAmount(purchaseAmount);
        List<Lotto> lottos = new ArrayList<>();
        int lottoSize = purchaseAmount / Constant.LOTTO_PRICE;
        for (int index = 0; index < lottoSize; ++index) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(
                    Constant.MIN_NUMBER,
                    Constant.MAX_NUMBER,
                    Constant.NUMBERS_SIZE));
            lottos.add(lotto);
        }
        return lottos;
    }
}
