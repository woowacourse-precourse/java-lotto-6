package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        View view = new View();

        int purchaseMoney = view.askPurchaseMoney();
        LottoMachine lottoMachine = new LottoMachine(purchaseMoney);
        showPurchaseLotto(lottoMachine, view);
    }

    private static void showPurchaseLotto(LottoMachine lottoMachine,
                                          View view) {
        List<Lotto> lottoTickets = lottoMachine.getLottoTickets();
        view.showLottoTickets(lottoTickets);
    }
}
