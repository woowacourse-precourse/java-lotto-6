package domain;

import java.util.List;
import validator.InputValidator;

public class LottoMachine {
    private final int spend;
    private final List<Lotto> lottoTickets;

    public LottoMachine(int spend, List<Lotto> lottoTickets) {
        validateSpend(spend);
        this.spend = spend;
        this.lottoTickets = lottoTickets;
    }

    public int getSpend() {
        return spend;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public void validateSpend(int spend) {
        InputValidator.validatePurchaseAmount(spend);
    }
}
