package lotto.fixture;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoFixture {
    public static Lotto lottoFixture(List<Integer> numbers) {
        return new Lotto(lottoNumbers(numbers));
    }

    public static List<LottoNumber> lottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoFixture::lottoNumber)
                .toList();
    }

    private static LottoNumber lottoNumber(int number) {
        return LottoNumber.from(number);
    }
}
