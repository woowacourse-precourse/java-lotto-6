package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.service.NumbersGenerator;

public class RandomNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> generate(int startNumber, int endNumber, int count) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                startNumber, endNumber, count);

        ArrayList<Integer> numbersToSort = new ArrayList<>(numbers);
        Collections.sort(numbersToSort);

        return numbersToSort;
    }
}