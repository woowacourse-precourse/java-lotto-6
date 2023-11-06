package lotto.lotto;

import static lotto.error.message.InvalidStateErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND;
import static lotto.error.message.InvalidStateErrorMessage.PURCHASE_AMOUNT_UNDER_THOUSAND;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.error.exception.InvalidStateException;

public class LottoVendor {
    public List<Lotto> generateLottos(Integer purchaseAmount) {
        validate(purchaseAmount);

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

    private void validate(Integer purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new InvalidStateException(PURCHASE_AMOUNT_UNDER_THOUSAND.getMessage(), purchaseAmount);
        }
        if (purchaseAmount % 1000 != 0) {
            throw new InvalidStateException(PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND.getMessage(), purchaseAmount);
        }
    }
}
