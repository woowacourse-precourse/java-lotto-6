package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumberRandomGenerator {
    public List<Integer> generate(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        validate(numbers);
        return numbers;
    }

    public void validate(List<Integer> inputValue) {

    }
}
