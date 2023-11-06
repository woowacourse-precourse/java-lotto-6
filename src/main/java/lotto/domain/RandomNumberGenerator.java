package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> getRandomNumber(int start, int end, int count) {
        return sortNumbers(Randoms.pickUniqueNumbersInRange(start, end, count));
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
