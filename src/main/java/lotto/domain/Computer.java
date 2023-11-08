package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoGameConfig;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private Lotto lotto;

    public List<Lotto> generateLottos(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int drawAttempt = 0; drawAttempt < money / LottoGameConfig.LOTTO_TICKET_PRICE_UNIT.getNumber(); drawAttempt++) {
            List<Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(LottoGameConfig.MIN_LOTTO_NUMBER_RANGE.getNumber(), LottoGameConfig.MAX_LOTTO_NUMBER_RANGE.getNumber(), LottoGameConfig.LOTTO_NUMBER_COUNT.getNumber()));
            lotto = new Lotto(numbers);
            lottos.add(lotto.getPuschaseLotto());
        }
        return lottos;
    }
}