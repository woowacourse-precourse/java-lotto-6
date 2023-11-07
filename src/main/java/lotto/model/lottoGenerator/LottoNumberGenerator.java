package lotto.model.lottoGenerator;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public class LottoNumberGenerator {
    public List<Integer> generateNumbers() {
        Set<Integer> generatedNumbers = new HashSet<>();
        while (generatedNumbers.size() < 6) {
            int number = pickNumberInRange(1, 45);
            generatedNumbers.add(number);
        }
        List<Integer> sortedNumbers = new ArrayList<>(generatedNumbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}





