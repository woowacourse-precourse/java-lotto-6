package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static List<Integer> generateLottoNumbers(int numberOfNumbersToGenerate) {

        List<Integer> generatedNumbers = new ArrayList<>();

        for (int i = 0; i < numberOfNumbersToGenerate; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            generatedNumbers.addAll(numbers);
        }
        return generatedNumbers;
    }

}
