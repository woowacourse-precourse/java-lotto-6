package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;

import java.util.List;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {
        View view = new View();

        LottoMachine lottoMachine = purchaseLotto(view);
        showPurchaseLotto(lottoMachine, view);

        Lotto winningLottoTicket = askWinningLottoTicket(view);
        WinningLotto winningLotto = askWinningLotto(view, winningLottoTicket);

        LottoResult lottoResult = lottoMachine.calculatePrize(winningLotto);
        view.showLottoResult(lottoResult);
    }

    private static LottoMachine purchaseLotto(View view) {
        return runUntilValidInput(view, () -> createLottoMachine(view));
    }

    private static void showPurchaseLotto(LottoMachine lottoMachine,
                                          View view) {
        List<Lotto> lottoTickets = lottoMachine.getLottoTickets();
        view.showPurchaseLotto(lottoTickets);
    }

    private static Lotto askWinningLottoTicket(View view) {
        return runUntilValidInput(view, () -> createWinningNumbers(view));
    }

    private static WinningLotto askWinningLotto(View view, Lotto winningLottoTicket) {
        return runUntilValidInput(view, () -> createWinningLotto(view, winningLottoTicket));
    }

    private static LottoMachine createLottoMachine(View view) {
        int purchaseMoney = view.askPurchaseMoney();
        return new LottoMachine(purchaseMoney);
    }

    private static Lotto createWinningNumbers(View view) {
        List<Integer> winningNumbers = view.askWinningNumbers();
        return new Lotto(winningNumbers);
    }

    private static WinningLotto createWinningLotto(View view, Lotto winningLottoTicket) {
        int bonusNumber = view.askBonusNumber();
        return new WinningLotto(winningLottoTicket, bonusNumber);
    }

    private static <T> T runUntilValidInput(View view, Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                view.showErrorMessage(e.getMessage());
            }
        }
    }
}
