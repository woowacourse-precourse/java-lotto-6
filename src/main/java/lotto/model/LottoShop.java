package lotto.model;

import java.util.List;
import lotto.constant.ErrorMessage;

public class LottoShop {
    private final LottoMachine lottoMachine;

    public LottoShop(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> createLottoTickets(int money) {
        validateMoney(money);
        int quantity = money / lottoMachine.getLottoTicketPrice();
        return lottoMachine.generateLottoTickets(quantity);
    }

    private void validateMoney(int money) {
        if (money <= 0 || money % getLottoTicketPrice() != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_PROPER_LOTTO_TICKET_PRICE.getMessage());
        }
    }

    public int getLottoTicketPrice() {
        return lottoMachine.getLottoTicketPrice();
    }
}