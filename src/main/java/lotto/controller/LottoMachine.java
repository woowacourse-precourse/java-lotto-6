package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.model.Result;
import lotto.model.User;
import lotto.view.OutputView;
import lotto.util.Computer;
import lotto.view.InputView;

public class LottoMachine {
    Result result = new Result();
    Computer computer = new Computer();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    User user = new User();

    public void startLottoGame() {
        buyLotto();
        drawLottoNumber();
        drawWinningNumber();
        getWinningStatistics();
    }

    public void buyLotto() {
        inputView.inputPaymentAmount(user);
        computer.calculateLottoTicketCount(user);
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
        outputView.printWinningStatistics(result.getWinningCount());
        outputView.printTotalProfit(result);
    }

    public void compareLottoTicket() {
        for (Lotto lotto : result.getLottoTicket()) {
            compareNumber(lotto.getNumbers(), user.getWinningNumber().getNumbers());
        }
        computer.calculateTotalPrize(result);
        computer.calculateTotalProfit(result, user);
    }

    public void compareNumber(List<Integer> lottoNumbers, List<Integer> winningLottoNumbers) {
        int matchCount = getMatchCount(lottoNumbers, winningLottoNumbers);
        if (matchCount != 5) {
            addLottoWinning(matchCount);
        }
        if (matchCount == 5) {
            addSecondWinning(lottoNumbers);
        }
    }

    public int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningLottoNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningLottoNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public void addLottoWinning(int matchCount) {
        if (matchCount == 6) {
            result.addWinningCount(1);
        }
        if (matchCount == 4) {
            result.addWinningCount(4);
        }
        if (matchCount == 3) {
            result.addWinningCount(5);
        }
    }

    public void addSecondWinning(List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(user.getBonusNumber())) {
            result.addWinningCount(2);
            return;
        }
        result.addWinningCount(3);
    }
}
