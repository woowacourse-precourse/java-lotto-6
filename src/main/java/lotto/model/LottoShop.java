package lotto.model;

public class LottoShop {

    private final long lottoPrice;

    private LottoShop(long lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public static LottoShop ofPrice(long lottoPrice) {
        return new LottoShop(lottoPrice);
    }

    public LottoTicket issueLottoTicket(long money) {
        validate(money);
        long numberOfPlays = calculatePlayCount(money);
        return new LottoTicket(numberOfPlays);
    }

    private long calculatePlayCount(long money) {
        if (hasChange(money)) {
            throw new IllegalArgumentException();
        }
        return money / lottoPrice;
    }

    private boolean hasChange(long money) {
        return money % lottoPrice != 0;
    }

    private void validate(long money) {
        if (isLessThanLottoPrice(money)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isLessThanLottoPrice(long money) {
        return money < lottoPrice;
    }
}
