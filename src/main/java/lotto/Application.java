package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        List<Lotto> myLottoTickets = lottoManager.purchaseLottoTickets();
        lottoManager.printLottoTickets(myLottoTickets);

        lottoManager.checkMyWinning();
    }
}
