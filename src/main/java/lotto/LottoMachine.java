package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.code.GameMessage;
import lotto.dto.LottoPurchaseDto;
import lotto.utils.InputUtils;
import lotto.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.Constant.LOTTO_AMOUNT;

/**
 * LottoMachine
 * <pre>
 * Describe here
 * </pre>
 *
 * @version 1.0,
 */

public class LottoMachine {

    public LottoPurchaseDto purchase() {
        int amount = InputUtils.getAmount();

        int lottoCount = amount / LOTTO_AMOUNT;
        PrintUtils.print("");
        PrintUtils.print(lottoCount + GameMessage.LOTTO_COUNT.getMessage());
        return new LottoPurchaseDto(amount, lottoCount);
    }


    public List<Lotto> publish(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
