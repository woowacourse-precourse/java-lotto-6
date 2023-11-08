package domain;

import java.util.List;
import validator.Validator;

public class LottoMachine {
    private final int spend;
    private final List<Lotto> lottoTickets;

    public LottoMachine(int spend, List<Lotto> lottoTickets) throws IllegalArgumentException {
        validateSpend(spend);
        this.spend = spend;
        this.lottoTickets = lottoTickets;
    }

    public void validateSpend(int spend) {
        Validator.validatePurchaseAmount(spend);
    }

    public int getSpend() {
        return spend;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
