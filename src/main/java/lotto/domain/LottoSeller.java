package lotto.domain;

public class LottoSeller {
    private final LottoMachine lottoMachine;

    public LottoSeller(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottoBundle sell(long fee) {
        return lottoMachine.createLottoBundle(new Money(fee).toLottoCnt());
    }
}
