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
        long numberOfPlays = calculatePlayCount(money);
        return new LottoTicket(numberOfPlays);
    }

    private long calculatePlayCount(long money) {
        return money / lottoPrice;
    }
}
