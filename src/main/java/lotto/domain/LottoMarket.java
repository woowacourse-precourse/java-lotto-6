package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class LottoMarket {
    private final int lottoPrice;
    private final LottoFactory lottoFactory;

    public LottoMarket(int lottoPrice, LottoFactory lottoFactory) {
        this.lottoPrice = lottoPrice;
        this.lottoFactory = lottoFactory;
    }

    public LottoTicket buyLotto(int lottoBoughtPrice) {
        validate(lottoBoughtPrice);

        int lottoCount = getLottoCount(lottoBoughtPrice);
        return new LottoTicket(createLottos(lottoCount));
    }

    private void validate(int lottoBoughtPrice) {
        validateRange(lottoBoughtPrice);
        validateNoRecharge(lottoBoughtPrice);
    }

    private void validateRange(int lottoBoughtPrice) {
        if (lottoBoughtPrice < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoRecharge(int lottoBoughtPrice) {
        if (lottoBoughtPrice % lottoPrice != 0) {
            throw new IllegalArgumentException();
        }
    }

    private int getLottoCount(int lottoBoughtPrice) {
        return lottoBoughtPrice / lottoPrice;
    }

    private List<Lotto> createLottos(int lottoCount) {
        return Stream.generate(lottoFactory::create)
                .limit(lottoCount)
                .toList();
    }
}
