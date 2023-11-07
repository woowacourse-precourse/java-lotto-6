package lotto.domian;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoughtLotto {
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int PICK_LOTTO_COUNT = 6;

    private List<Integer> numbers;
    public List<Integer> generateLottoNumbers() {
        numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, PICK_LOTTO_COUNT);
        List<Integer> randNumbers = new ArrayList<>(numbers);
        Collections.sort(randNumbers);
        return randNumbers;
    }
}
