package lotto.fixture;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoFixture {
    public static Lotto lottoFixture(List<Integer> numbers) {
        return new Lotto(lottoNumberFixtures(numbers));
    }

    public static List<LottoNumber> lottoNumberFixtures(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoFixture::lottoNumberFixture)
                .toList();
    }

    private static LottoNumber lottoNumberFixture(int number) {
        return LottoNumber.from(number);
    }
}
