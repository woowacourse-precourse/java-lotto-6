package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Constant.LottoNumber;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> generate() {
        List<Integer> randomNumbers = generateRandomNumbers();
        return sortNumbers(randomNumbers);
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_INCLUSIVE.getNumber(),
                LottoNumber.MAX_INCLUSIVE.getNumber(), LottoNumber.COUNT.getNumber());
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
