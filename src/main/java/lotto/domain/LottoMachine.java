package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.Constant;
import lotto.constant.ErrorMessage;

public class LottoMachine {

    public final List<Lotto> issueLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
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

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % Constant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE.getMessage());
        }
        if (purchaseAmount / Constant.LOTTO_PRICE < Constant.MIN_LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE.getMessage());
        }
    }
}
