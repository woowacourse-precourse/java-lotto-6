package lotto.helper;

import java.util.List;
import lotto.fixture.LottoFixture;
import lotto.model.LottoNumber;
import lotto.model.NumbersGenerator;

public class TestLottoNumbersGenerator implements NumbersGenerator<LottoNumber> {

    private final List<LottoNumber> numbers;

    public TestLottoNumbersGenerator(final List<Integer> numbers) {
        this.numbers = LottoFixture.createLottoNumbers(numbers);
    }

    @Override
    public List<LottoNumber> generate() {
        return numbers;
    }
}
