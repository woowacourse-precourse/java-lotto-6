package lotto.service;

import java.math.BigDecimal;
import lotto.model.Money;
import lotto.model.RandomLottoTickets;
import lotto.model.WinningLottoTicket;
import lotto.repository.Result;

public class LottoService {

    private final Result result;

    public LottoService(Result result) {
        this.result = result;
    }

    public void sort(RandomLottoTickets randomLottoTickets, WinningLottoTicket winningLottoTicket) {
        result.init();
        randomLottoTickets.sort(winningLottoTicket)
                .forEach(o -> o.ifPresent(result::add));
    }

    public String getResult() {
        return result.toString();
    }

    public BigDecimal getRateOfReturn(Money money) {
        return result.rateOfReturn(money);
    }
}
