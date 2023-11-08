package lotto.domain.number;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.utils.Constants.*;

public class RandomNumberStrategy implements NumberStrategy{
    @Override
    public Lotto generateNumber() {
        List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT));
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }
}
