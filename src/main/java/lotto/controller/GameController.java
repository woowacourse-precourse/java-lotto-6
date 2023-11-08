package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.constant.ConfigurationNumbers;
import lotto.constant.Rank;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Pay;
import lotto.view.ErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final double PERCENTAGE = 100.0;
    Pay pay;
    private Game game = new Game();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ErrorView errorView = new ErrorView();


    public void run() {
        pay();
        buyLotto();
        setWinningNumber();
        setBonusNumber();
        printResult();
    }

    private void pay() {
        try {
            String input = inputView.requestPayment();
            pay = new Pay(input);
        } catch (IllegalArgumentException exception) {
            errorView.printErrorMessage(exception.getMessage());
            pay();
        }
    }

    private void buyLotto() {
        game.generateUserLottos(pay.getLottoAmounts());
        printUserLottos(game.getLottos());
    }

    private void printUserLottos(List<Lotto> userLottos) {
        outputView.printAmmountLotto(userLottos.size());
        for (Lotto lotto : userLottos) {
            outputView.printLottoNumbers(lotto.getNumbers());
        }
    }

    private void setWinningNumber() {
        try {
            String input = inputView.requestWinningNumber();
            game.generateWinnerNumber(input);
        } catch (IllegalArgumentException exception) {
            errorView.printErrorMessage(exception.getMessage());
            setWinningNumber();
        }
    }

    private void setBonusNumber() {
        try {
            String input = inputView.requestBonusNumber();
            game.generateBonusNumber(input);
        } catch (IllegalArgumentException exception) {
            errorView.printErrorMessage(exception.getMessage());
            setBonusNumber();
        }
    }

    private void printResult() {
        Map<Rank, Integer> ranks = game.compare();
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NOTHING) {
                outputView.printResult(rank.getResult(), ranks.get(rank));
            }
        }
        int profit = calculateTotalProfit(ranks);
        calculateProfitRate(profit);
    }

    private int calculateTotalProfit(Map<Rank, Integer> ranks) {
        int totalProfit = ranks.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
        return totalProfit;
    }

    private void calculateProfitRate(int profit) {
        double cost = pay.getLottoAmounts() * ConfigurationNumbers.PRICE.getNumber();
        double profitRate = ((double) profit / cost) * PERCENTAGE;
        String result = String.format("%.1f", profitRate);
        outputView.printProfitRate(result);
    }
}
