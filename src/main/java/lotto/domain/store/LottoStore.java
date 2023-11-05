package lotto.domain.store;

import lotto.domain.lotto.Lottos;
import lotto.domain.generator.LottoAutoGenerator;
import lotto.domain.generator.LottoManualGenerator;
import lotto.exception.LottoException;
import lotto.exception.MarketException;

import static lotto.constant.LottoConstants.LOTTO_PRICE;
import static lotto.constant.LottoConstants.MAX_LOTTO_PRICE_PER_USER;

public class LottoStore {
    private final LottoAutoGenerator lottoAutoGenerator;
    private final LottoManualGenerator lottoManualGenerator;

    public LottoStore(LottoAutoGenerator lottoAutoGenerator, LottoManualGenerator lottoManualGenerator) {
        this.lottoAutoGenerator = lottoAutoGenerator;
        this.lottoManualGenerator = lottoManualGenerator;
    }

    public Lottos purchaseAutoLottos(int userMoney) throws LottoException {
        validate(userMoney);
        int lottoCount = userMoney / LOTTO_PRICE.getValue();
        return lottoAutoGenerator.generate(lottoCount);
    }

    private void validate(int money) throws MarketException {
        if (!isValidMoney(money)) {
            throw new MarketException(MarketException.ErrorMessage.VALID_MONEY.getMessage());
        }

        if (!isDivisibleByLottoPrice(money)) {
            throw new MarketException(MarketException.ErrorMessage.NOT_DIVISIBLE.getMessage());
        }

        if (isExceedMaxLottoAmountPerUser(money)) {
            throw new MarketException(MarketException.ErrorMessage.EXCEED_MAX_LOTTO_AMOUNT.getMessage());
        }
    }

    private boolean isValidMoney(int money) {
        return money >= LOTTO_PRICE.getValue();
    }

    private boolean isDivisibleByLottoPrice(int money) {
        return (money % LOTTO_PRICE.getValue()) == 0;
    }

    private boolean isExceedMaxLottoAmountPerUser(int money) {
        return money > MAX_LOTTO_PRICE_PER_USER.getValue();
    }
}
