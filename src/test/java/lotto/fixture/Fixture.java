package lotto.fixture;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.prize.PrizeNumber;

public class Fixture {
    public static Lotto createContinuousLotto(final int startInclusive, final int endInclusive) {
        return new Lotto(
                IntStream.rangeClosed(startInclusive, endInclusive).boxed()
                        .map(LottoNumber::new)
                        .toList()
        );
    }

    public static Lotto createContinuousLottoNumbers(final int... values) {
        return new Lotto(
                Arrays.stream(values)
                        .mapToObj(LottoNumber::new)
                        .toList()
        );
    }


    public static List<PrizeNumber> createContinuousPrizeNumbers(
            final int startInclusive,
            final int endInclusive
    ) {
        return IntStream.rangeClosed(startInclusive, endInclusive).boxed()
                .map(PrizeNumber::new)
                .toList();
    }

    public static List<PrizeNumber> createPrizeNumbers(final int... values) {
        return Arrays.stream(values)
                .mapToObj(PrizeNumber::new)
                .toList();
    }
}
