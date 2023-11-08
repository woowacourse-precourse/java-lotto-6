package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoInformation;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private Lotto lotto;

    public List<Lotto> drawLottoRandomNumber(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int drawAttempt = 0;  drawAttempt < money / LottoInformation.MONEY_UNIT.getNumber(); drawAttempt++) {
            List<Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(LottoInformation.MIN_LOTTO_NUMBER.getNumber(), LottoInformation.MAX_LOTTO_NUMBER.getNumber(), LottoInformation.LOTTO_NUMBER_TOTAL_SIZE.getNumber()));
            lotto = new Lotto(numbers);
            lottos.add(lotto.getPuschaseLotto());
        }
        return lottos;
    }
}
