package lotto.Service.LottoNumberService.RandomGenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Common.LottoValue;
import lotto.Model.Lotto.Lotto;

public class GenerateRandomNumber {

    public Lotto generateUniqueLottoNumbers() {
        int minNumber = LottoValue.LOTTO_FIRST_NUMBER.getValue();
        int maxNumber = LottoValue.LOTTO_FINAL_NUMBER.getValue();
        int countNumber = LottoValue.LOTTO_COUNT_NUMBER.getValue();
        List<Integer> uniqueNumbers;

        do {
            uniqueNumbers = Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, countNumber);
        } while (validateLottoNumbersDuplicates(uniqueNumbers).size() != countNumber);

        return sortingLottoNumber(uniqueNumbers);
    }

    public List<Integer> validateLottoNumbersDuplicates(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .collect( Collectors.toList());
    }



    public Lotto sortingLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.collectingAndThen( Collectors.toList(), Lotto::new));
    }

}
