package lotto;

public class LottoMachine {
    public LottoEnvelope createLottoEnvelope(Integer count) {
        return new LottoEnvelope(count);
    }
}
