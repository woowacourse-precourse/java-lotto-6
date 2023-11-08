package lotto.domain;

import static lotto.constants.Common.LOTTO_TICKET_PRICE;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private final LottoService lottoService;
    private long purchaseAmount;
    private int bonusNumber;
    private Lotto winningTicket;
    private List<Lotto> purchasedTickets;

    public GameService() {
        this.purchasedTickets = new ArrayList<>();
        this.lottoService = new LottoService();
    }

    public List<Lotto> getPurchasedTickets() {
        return this.purchasedTickets;
    }

    public void setPurchaseAmount(long price) {
        this.purchaseAmount = price / LOTTO_TICKET_PRICE;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setWinningTicket(List<Integer> winningNumbers) {
        this.winningTicket = this.lottoService.createLottoTicket(winningNumbers);
    }

    public void purchaseTickets() {
        this.purchasedTickets = this.lottoService.purchaseLottoTickets(this.purchaseAmount);
    }

    public void processGame() {
        this.lottoService.compareForEachTickets(this.purchasedTickets, this.winningTicket, this.bonusNumber);
    }
}
