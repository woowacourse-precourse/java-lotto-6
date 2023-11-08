package lotto;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        View view = new View();

        int purchaseMoney = view.askPurchaseMoney();
        LottoMachine lottoMachine = new LottoMachine(purchaseMoney);
        showPurchaseLotto(lottoMachine, view);

        List<Integer> winningNumbers = view.askWinningNumbers();
        Lotto winningLottoTicket = new Lotto(winningNumbers);

        int bonusNumber = view.askBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningLottoTicket, bonusNumber);
        LottoResult lottoResult = lottoMachine.calculatePrize(winningLotto);

        view.showLottoResult(lottoResult);
    }

    private static void showPurchaseLotto(LottoMachine lottoMachine,
                                          View view) {
        List<Lotto> lottoTickets = lottoMachine.getLottoTickets();
        view.showLottoTickets(lottoTickets);
    }
}
