package lotto.module.manager;

import lotto.module.console.Console;
import lotto.module.console.ConsoleMessageComposer;
import lotto.module.domain.PurchaseAmount;
import lotto.module.domain.lotto.Lotto;
import lotto.module.domain.lotto.WinningLotto;
import lotto.module.result.LottoResult;

import java.util.List;

public class LottoConsoleManager {
    private final Console console;
    private final ConsoleMessageComposer consoleMessageComposer;

    private LottoConsoleManager(Console console, ConsoleMessageComposer consoleMessageComposer) {
        this.console = console;
        this.consoleMessageComposer = consoleMessageComposer;
    }

    public static LottoConsoleManager of(Console console, ConsoleMessageComposer consoleMessageComposer) {
        return new LottoConsoleManager(console, consoleMessageComposer);
    }

    public PurchaseAmount getPurchaseAmount() {
        int payment = console.getPurchaseAmount();

        return PurchaseAmount.newInstance(payment);
    }

    public void printPurchasedLottoTickets(List<Lotto> purchasedLottoTickets) {
        String message = consoleMessageComposer.makePurchasedLottoTicketMessage(purchasedLottoTickets);

        console.printPurchasedLottoTickets(message);
    }

    public WinningLotto getWinningLottoNumbers() {
        List<Integer> winningLottoNumbers = console.getWinningLottoNumbers();
        int lottoBonusNumber = console.getLottoBonusNumber();

        return WinningLotto.of(winningLottoNumbers, lottoBonusNumber);
    }

    public void printLottoWinningResult(LottoResult lottoResult) {

    }

}
