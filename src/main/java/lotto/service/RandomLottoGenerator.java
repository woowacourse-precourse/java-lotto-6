package lotto.service;

import static lotto.constants.RangeType.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class RandomLottoGenerator {

    private final int amount;

    public RandomLottoGenerator(int amount) {
        this.amount = amount;
    }

    public Lottos generate() {
        int count = convertAmountToCount(amount);
        Lottos lottos = new Lottos();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = getRandomNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.save(lotto);
        }
        return lottos;
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(PRIZE_NUMBER_MIN_RANGE.getRange(),
                PRIZE_NUMBER_MAX_RANGE.getRange(), PRIZE_NUMBER_SIZE.getRange());
        return numbers;
    }

    private int convertAmountToCount(int amount) {
        return amount / DIVISION_UNIT.getRange();
    }


}
