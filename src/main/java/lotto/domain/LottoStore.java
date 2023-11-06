package lotto.domain;

import java.util.List;

public class LottoStore {

    public List<Lotto> userLottoTickets;

    public void buyLottoTickets(String lottoPurchaseRequest) {
        List<Lotto> userLottoTickets = LottoStoreClerk.createLottoTickets(lottoPurchaseRequest);
        this.userLottoTickets = userLottoTickets;
    }

    public List<Lotto> getUserLottoTickets() {
        return userLottoTickets;
    }
}
