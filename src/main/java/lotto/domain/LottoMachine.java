package lotto.domain;

public class LottoMachine {
    private static final int PURCHASE_LOTTO_MONEY = 1000;
    private final LottoGenerator lottoGenerator;

    public LottoMachine(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public LottoTicket buy(Money money) {
        int lottoCount = getLottoCount(money);
        return new LottoTicket(lottoCount, lottoGenerator);
    }

    private int getLottoCount(Money money) {
        int requestMoney = money.getMoney();
        return requestMoney / PURCHASE_LOTTO_MONEY;
    }
}
