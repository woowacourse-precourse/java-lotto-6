package lotto.controller;

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
        for (int i = 0; i < user.getLottoTicketCount(); i++) {
            computer.getLottoNumber(result);
        }
        outputView.printLottoNumber(result.getLottoTicket(), user);
    }

    public void drawWinningNumber() {
        inputView.inputWinningNumber(user);
        inputView.inputBonusNumber(user);
    }

    public void getWinningStatistics() {
        compareLottoTicket();
        result.setTotalPrize(computer.calculateTotalPrize(result.getWinningCount()));
        result.setTotalProfit(computer.calculateTotalProfit(result.getTotalPrize(), user.getPaymentAmount()));
        outputView.printWinningStatistics(result.getWinningCount());
        outputView.printTotalProfit(result);
    }

    public void compareLottoTicket() {
        //key:rank value:count
        HashMap<Integer, Integer> winningCount = new HashMap<>();
        for (Lotto lotto : result.getLottoTicket()) {
            compareNumber(lotto.getNumbers(), winningCount);
        }
        result.setWinningCount(winningCount);
    }

    public void compareNumber(List<Integer> lottoNumbers, HashMap<Integer, Integer> winningCount) {
        int matchCount = getMatchCount(lottoNumbers);
        if (matchCount != 5) {
            addLottoWinning(matchCount, winningCount);
        }
        if (matchCount == 5) {
            addSecondWinning(lottoNumbers, winningCount);
        }
    }

    public int getMatchCount(List<Integer> lottoNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (user.getWinningNumber().getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public void addLottoWinning(int matchCount, HashMap<Integer, Integer> winningCount) {
        if (matchCount == 6) {
            winningCount.merge(1, 1, Integer::sum);
        }
        if (matchCount == 4) {
            winningCount.merge(4, 1, Integer::sum);
        }
        if (matchCount == 3) {
            winningCount.merge(5, 1, Integer::sum);
        }
    }

    public void addSecondWinning(List<Integer> lottoNumbers, HashMap<Integer,Integer> winningCount) {
        if (lottoNumbers.contains(user.getBonusNumber())) {
            winningCount.merge(2, 1, Integer::sum);
            return;
        }
        winningCount.merge(3, 1, Integer::sum);
    }
}
