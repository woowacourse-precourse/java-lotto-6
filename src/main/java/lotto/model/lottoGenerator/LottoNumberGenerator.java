package lotto.model.lottoGenerator;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static lotto.constant.NumberConstant.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public class LottoNumberGenerator {
    public List<Integer> generateNumbers() {
        Set<Integer> generatedNumbers = new HashSet<>();
        while (generatedNumbers.size() < GENERATED_NUMBERS_SIZE) {
            int number = pickNumberInRange(MIN_NUMBER_RANGE , MAX_NUMBER_RANGE );
            generatedNumbers.add(number);
        }
        List<Integer> sortedNumbers = new ArrayList<>(generatedNumbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}





