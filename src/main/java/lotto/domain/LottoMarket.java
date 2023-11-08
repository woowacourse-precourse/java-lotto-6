package lotto.domain;

import lotto.domain.exception.IllegalLottoPriceException;
import lotto.domain.exception.LottoRechargeExistException;

import java.util.List;
import java.util.stream.Stream;

public class LottoMarket {
    private final LottoFactory lottoFactory;

    public LottoMarket(LottoFactory lottoFactory) {
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
            throw new IllegalLottoPriceException();
        }
    }

    private void validateNoRecharge(int lottoBoughtPrice) {
        if (lottoBoughtPrice % Lotto.LOTTO_PRICE != 0) {
            throw new LottoRechargeExistException();
        }
    }

    private int getLottoCount(int lottoBoughtPrice) {
        return lottoBoughtPrice / Lotto.LOTTO_PRICE;
    }

    private List<Lotto> createLottos(int lottoCount) {
        return Stream.generate(lottoFactory::create)
                .limit(lottoCount)
                .toList();
    }
}
