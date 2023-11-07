package lotto.util.RandomGenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Common.LottoValue;

public class GenerateRandomNumber implements LottoGeneratorValidator {

    @Override
    public List<Integer> generateUniqueLottoNumbers() {
        int minNumber = LottoValue.LOTTO_FIRST_NUMBER.getValue();
        int maxNumber = LottoValue.LOTTO_FINAL_NUMBER.getValue();
        int countNumber = LottoValue.LOTTO_COUNT_NUMBER.getValue();

        List<Integer> uniqueNumbers;
        do {
            uniqueNumbers = Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, countNumber);
        } while (validateLottoNumbers(uniqueNumbers).size() != countNumber);

        return uniqueNumbers;
    }

    public List<Integer> validateLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .collect(Collectors.toList());
    }

}
