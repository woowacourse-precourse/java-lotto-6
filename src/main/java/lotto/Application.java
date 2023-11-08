package lotto;

import java.util.Optional;
import lotto.domain.AutoCreatedLottoGame;
import lotto.domain.AutoLottoNumberGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoTicketDispenser;
import lotto.domain.NumberGenerateStrategy;
import lotto.domain.PurchasedLottoStatistics;
import lotto.domain.PurchasedLottoTickets;
import lotto.domain.ViewContract;
import lotto.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        LottoGameRunner gameRunner = provideLottoGameController();
        Optional<PurchasedLottoTickets> purchasedLottoTickets;
        Optional<Lotto> winningLotto;
        Optional<PurchasedLottoStatistics> purchasedLottoStatistics;
        // TODO: 프로그램 구현
        do {
            purchasedLottoTickets = gameRunner.purchaseLotto();
        } while (purchasedLottoTickets.isEmpty());
    }

    private static LottoGameRunner provideLottoGameController() {
        return new LottoGameRunner(provideView(), provideLottoGame());
    }

    private static ViewContract provideView() {
        return new ConsoleView();
    }

    private static LottoGame provideLottoGame() {
        return new AutoCreatedLottoGame(provideLottoTicketDispenser());
    }

    private static LottoTicketDispenser provideLottoTicketDispenser() {
        return new LottoTicketDispenser(provideNumberGenerateStrategy());
    }

    private static NumberGenerateStrategy provideNumberGenerateStrategy() {
        return new AutoLottoNumberGenerator();
    }
}

