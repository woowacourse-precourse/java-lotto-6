package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.model.Result;
import lotto.model.User;
import lotto.view.OutputView;
import lotto.util.Computer;
import lotto.view.InputView;

public class LottoMachine {
    User user = new User();
    Result result = new Result();
    Computer computer = new Computer();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void startLottoGame() {
        buyLotto();
        drawLottoNumber();
        drawWinningNumber();
        getWinningStatistics();
    }

    public void buyLotto() {
        inputView.inputPaymentAmount(user);
        user.setLottoTicketCount(computer.calculateLottoTicketCount(user.getPaymentAmount()));
    }

    public void drawLottoNumber() {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < user.getLottoTicketCount(); i++) {
            lottoTickets.add(computer.getLottoNumber());
        }
        result.setLottoTickets(lottoTickets);
        outputView.printLottoNumber(result.getLottoTickets(), user);
    }

    public void drawWinningNumber() {
        inputView.inputWinningNumber(user);
        inputView.inputBonusNumber(user);
    }

    public void getWinningStatistics() {
        result.setWinningCount(countWinningLottoTicket());
        result.setTotalPrize(computer.calculateTotalPrize(result.getWinningCount()));
        result.setTotalProfit(computer.calculateTotalProfit(result.getTotalPrize(), user.getPaymentAmount()));
        outputView.printWinningStatistics(result.getWinningCount());
        outputView.printTotalProfit(result);
    }

    public HashMap<Integer, Integer> countWinningLottoTicket() {
        //key:rank value:count
        HashMap<Integer, Integer> winningCount = new HashMap<>();
        for (Lotto lotto : result.getLottoTickets()) {
            compareNumber(lotto.getNumbers(), winningCount);
        }
        return winningCount;
    }

    public void compareNumber(List<Integer> lottoNumbers, HashMap<Integer, Integer> winningCount) {
        int matchCount = computer.getMatchCount(lottoNumbers, user.getWinningNumber());
        if (matchCount != 5) {
            int rank = computer.getWinningRank(matchCount);
            winningCount.merge(rank, 1, Integer::sum);
        }
        if (matchCount == 5) {
            int rank = computer.getWinningSecondRank(lottoNumbers, user.getBonusNumber());
            winningCount.merge(rank, 1, Integer::sum);
        }
    }
}
