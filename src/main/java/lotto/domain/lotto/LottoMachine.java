package lotto.domain.lotto;

import static lotto.global.constant.LottoConstant.LOTTO_NUMBER_AMOUNT;
import static lotto.global.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.global.constant.LottoConstant.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Money;
import lotto.global.constant.message.ErrorMessage;
import lotto.global.exception.LottoIllegalArgumentException;

public class LottoMachine {
    private final int lottoPrice;

    public LottoMachine(int lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public List<Lotto> purchaseLottos(Money money) {
        validateMoneyUnit(money);
        int count = money.getAmount() / lottoPrice;

        return generateLottos(count);
    }

    private void validateMoneyUnit(Money money) {
        if (money.getAmount() % lottoPrice != 0) {
            throw new LottoIllegalArgumentException(ErrorMessage.MONEY_UNIT_ERROR);
        }
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
