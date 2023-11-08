package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class BuyLottos {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int PICK_LOTTO_COUNT = 6;
    private List<Integer> numbers;

    public List<Integer> butLottos() {
        numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, PICK_LOTTO_COUNT);
        List<Integer> randomNumbers = new ArrayList<>(numbers);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
