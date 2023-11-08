package lotto.fixture;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class LottoFixture {

    public static Lotto createLotto(final List<Integer> numbers) {
        return new Lotto(createLottoNumbers(numbers));
    }

    public static List<LottoNumber> createLottoNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .map(number -> LottoNumber.createWith(Integer.toString(number)))
                .toList();
    }
}
