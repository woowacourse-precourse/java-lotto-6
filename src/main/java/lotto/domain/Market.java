package lotto.domain;

import lotto.exception.MarketException;

public class Market {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_LOTTO_PRICE_PER_USER = 100_000;

    private final LottoAutoGenerator lottoAutoGenerator;

    public Market(LottoAutoGenerator lottoAutoGenerator) {
        this.lottoAutoGenerator = lottoAutoGenerator;
    }

    public Lottos buyLottos(int userMoney) {
        validate(userMoney);
        int lottoCount = userMoney / LOTTO_PRICE;

        return lottoAutoGenerator.generate(lottoCount);
    }

    private void validate(int money) throws MarketException {
        if (!isValidMoney(money)) {
            throw new MarketException("로또 금액은 " + LOTTO_PRICE + "원 입니다.");
        }

        if (!isDivisibleByLottoPrice(money)) {
            throw new MarketException("거스름돈이 존재하지 않습니다. 로또 한개 금액은 " + LOTTO_PRICE + " 원 입니다.");
        }

        if (isExceedMaxLottoCountPerUser(money)) {
            throw new MarketException("한 사람당 구매 가능한 로또 금액은 최대 " + MAX_LOTTO_PRICE_PER_USER + "원 입니다.");
        }
    }

    private boolean isValidMoney(int money) {
        return money >= LOTTO_PRICE;
    }

    private boolean isDivisibleByLottoPrice(int money) {
        return money % LOTTO_PRICE == 0;
    }

    private boolean isExceedMaxLottoCountPerUser(int money) {
        return money > MAX_LOTTO_PRICE_PER_USER;
    }
}
