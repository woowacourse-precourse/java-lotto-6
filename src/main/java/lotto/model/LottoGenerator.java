package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoGenerator {
    public LottoGenerator(int lottoCount) {
            Lotto ticket = new Lotto(sortAscending(pickSixLottoNumber()));
    }

    private List<Integer> pickSixLottoNumber() {
        final int MIN_LOTTO_NUMBER = 1;
        final int MAX_LOTTO_NUMBER = 45;
        final int LOTTO_NUMBER_COUNT = 6;
        return pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
    }

    public List<Integer> sortAscending(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

}
