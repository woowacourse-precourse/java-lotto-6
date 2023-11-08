package lotto.domain.lotto;

public class LottoMachine {

    public LottoCount getTotalCount(Price price) {
        return new LottoCount(price);
    }

}
