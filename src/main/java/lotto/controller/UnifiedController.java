package lotto.controller;

import static lotto.controller.DataController.calcGainPercentage;
import static lotto.controller.DataController.calcTotalPrizeAmount;
import static lotto.controller.DataController.getWinningCountsByRank;
import static lotto.controller.RegisterController.storeInputData;
import static lotto.controller.RegisterController.storeLotto;
import static lotto.view.OutputView.printLottoNumbers;
import static lotto.view.OutputView.printNumOfTickets;
import static lotto.view.SystemMessage.WINNING_RESULT;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Register;
import lotto.view.OutputView;
import lotto.view.SystemMessage;


public class UnifiedController {
    private Register register;

    public UnifiedController() {
        register = new Register();
    }

    public void promptData(SystemMessage systemMessage) {
        OutputView.printSystemMessage(systemMessage);
        waitForValidInput(systemMessage);
    }

    private void waitForValidInput(SystemMessage systemMessage) {
        boolean valid = false;
        while (!valid) {
            valid = checkNoException(systemMessage);
        }
    }

    private boolean checkNoException(SystemMessage systemMessage) {
        try {
            storeInputData(systemMessage, this.register);
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return false;
        }
    }

    public void displayLottoTicketsInfo() {
        storeLotto(this.register);
        printNumOfTickets(register.getLottoTickets().size());
        for (Lotto lotto : register.getLottoTickets()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            lottoNumbers.sort(Comparator.naturalOrder());
            printLottoNumbers(lottoNumbers);
        }
    }

    public void displayResult() {
        OutputView.printSystemMessage(WINNING_RESULT);
        Map<Rank, Long> winningCountByRank = getWinningCountsByRank(register.getLottoTickets(),
                register.getFirstPrizeLotto(), register.getBonus().getNumber());
        displayWinningLottoInfoByRank(winningCountByRank);
        long totalPrizeAmount = calcTotalPrizeAmount(winningCountByRank);
        double gainPercentage = calcGainPercentage(totalPrizeAmount, register.getMoney().getAmount());
        OutputView.printGainPercentage(gainPercentage);

    }

    private void displayWinningLottoInfoByRank(Map<Rank, Long> winningCountByRank) {
        for (Rank rank : Rank.values()) {
            OutputView.printWinningLottosInfo(rank, winningCountByRank.get(rank));
        }
    }

}
