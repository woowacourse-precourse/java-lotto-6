package lotto;

import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Simulation {
    private static final int TICKET_PRICE = 1000;
    private List<Lotto> lottoList;

    public Simulation() {
        lottoList = new ArrayList<>();
    }

    public void run() {
        try {
            buy();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void buy() {
        int ticketCount = InputView.inputNumber() / TICKET_PRICE;
        OutputView.printLottoCount(ticketCount);

        lottoList = InputView.generateLotto(ticketCount);
        OutputView.showLottoList(lottoList);

        Lotto lotto = InputView.inputWinnerLotto();
        int bonusNumber = InputView.inputBonusNumber();

        WinningLotto winner = new WinningLotto(lotto, bonusNumber);

        OutputView.printResult();

        Statistic result = new Statistic(lottoList, winner, ticketCount);
        result.lottoResult();
    }
}
