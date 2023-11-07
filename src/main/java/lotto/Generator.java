package lotto;

import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Generator {
    static final int start = 1;
    static final int end = 45;
    static final int lottoNumbersCount = 6;
    static final int bonusNumbersCount = 1;

    public List<Integer> numbersGenerator() {
        List <Integer> numbers = Randoms.pickUniqueNumbersInRange(start,end,lottoNumbersCount);
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> winNumbersGenerator() {
        return Randoms.pickUniqueNumbersInRange(start,end,lottoNumbersCount);
    }

    public int bonusNumberGenerator(List<Integer> winNumbers) {
        List<Integer> bonusNumber;
        do {
            bonusNumber = Randoms.pickUniqueNumbersInRange(start,end,bonusNumbersCount);
        } while (winNumbers.contains(bonusNumber));
        return bonusNumber.get(0);
    }


}
