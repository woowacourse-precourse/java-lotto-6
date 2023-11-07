package lotto;

import java.util.List;

public class LottoGame {

    public void startGame() {
        // 로또 생성
        Lotto winningLotto = Lotto.createRandomLotto();
        // 로또 구매
        LottoShop lottoShop = new LottoShop();
        LottoTicket purchasedTickets = lottoShop.buyLottoTicket();
    }
}
