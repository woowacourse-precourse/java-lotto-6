package lotto.domain.lotto;

import static lotto.global.constant.LottoConstant.LOTTO_NUMBER_AMOUNT;
import static lotto.global.constant.LottoConstant.LOTTO_PURCHASE_UNIT;
import static lotto.global.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.global.constant.LottoConstant.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Money;

public class LottoMachine {

    public List<Lotto> purchaseLottos(Money money) {
        int count = money.getAmount() / LOTTO_PURCHASE_UNIT;

        return generateLottos(count);
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }

        return lottos;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_AMOUNT);
    }
}
