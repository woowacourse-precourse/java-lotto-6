package lotto;

import java.util.ArrayList;
import java.util.Map;
import lotto.controller.InputController;
import lotto.controller.MainController;
import lotto.controller.OutputController;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningNumbers;

public class LottoGame {

    InputController inputController;
    OutputController outputController;
    MainController mainController;

        public LottoGame() {
            this.inputController = new InputController();
            this.outputController = new OutputController();
            this.mainController = new MainController();
        }

    public void run() {
        int ticketQuantity = inputController.settingTicketQuantity();
        outputController.orderPrintTicketQuantity(ticketQuantity);

        ArrayList<Lotto> consumerLottos = mainController.settingConsumerLottos(ticketQuantity);
        outputController.orderPrintConsumerLottos(consumerLottos);

        WinningNumbers winningNumbers = inputController.settingWinningNumbers();

        Map<Ranking, Integer> resultBoard = mainController.getRankingResult(consumerLottos, winningNumbers);
        outputController.orderPrintRanking(resultBoard);

        float returnOfRate = mainController.getReturnOfRate(resultBoard,ticketQuantity);
        outputController.orderPrintReturnOfRate(returnOfRate);
    }

}
