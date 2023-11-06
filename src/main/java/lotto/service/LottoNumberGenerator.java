package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

// sout할 때 애시당초 [ ..., ... ] 이런 식으로 표현됨
public class LottoNumberGenerator {
//    public List<Integer> generateNumbers() {
//        Set<Integer> numbers = filterDuplicates();
//
//        List<Integer> sortedNumbers = new ArrayList<>(numbers);
//        Collections.sort(sortedNumbers);
//
//        return sortedNumbers;
//    }

    public List<Integer> generateNumbers() {
        List<Integer> numbers;
        do {
            numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        } while (hasDuplicates(numbers));
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }

    private static boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int num : numbers) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

//    private Set<Integer> filterDuplicates() {
//        Set<Integer> numbers = new HashSet<>();
//
//        while (numbers.size() < 6) {
//            numbers.add(Randoms.pickNumberInRange(1, 45));
//        }
//
//        return numbers;
//    }
}
