package lotto.fixture;

import java.util.List;
import lotto.helper.TestLottoNumbersGenerator;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.NumbersGenerator;

public class LottosFixture {

    public static Lottos createLottos(final List<Integer> numbers) {
        NumbersGenerator<LottoNumber> numbersGenerator = new TestLottoNumbersGenerator(numbers);

        return Lottos.createWith(1L, numbersGenerator);
    }
}
