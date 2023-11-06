package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumbersGenerator implements NumbersGenerator<LottoNumber> {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Override
    public List<LottoNumber> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_NUMBER_COUNT);

        return convertToLottoNumbers(numbers);
    }

    private List<LottoNumber> convertToLottoNumbers(final List<Integer> numbers) {

        return numbers.stream()
                .map(number -> LottoNumber.createWith(Integer.toString(number)))
                .toList();
    }
}
