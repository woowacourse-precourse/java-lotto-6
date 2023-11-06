package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> getRandomNumber(int start, int end, int count) {
        return sortNumbers(Randoms.pickUniqueNumbersInRange(start, end, count));
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        numbers.stream().sorted().collect(Collectors.toList());
        return numbers;
    }
}
