package lotto.controller;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Result;
import lotto.domain.UserPrice;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    public static final int LOTTO_PRICE = 1000;


    public void run() {
        Map<Result, Integer> score = new HashMap<>();
        int totalProfit = 0;
        int totalInvestment = 0;

        OutputView.printBuyInputPrice();
        UserPrice userPrice = new UserPrice(InputView.inputUserPrice());
        Lotties lotties = userPrice.buy(LOTTO_PRICE);

        OutputView.printBuyLottoCount(lotties.size());
        OutputView.printLotties(lotties.getLottiesNumbers());

        WinningNumber winningNumber = inputWinningNumber();



        for (Result result : score.keySet()) {
            totalProfit += result.getWinnings() * score.get(result);
        }

        double profitPercentage = (totalProfit) / (double) totalInvestment * 100;
        DecimalFormat profitDecimal = new DecimalFormat("#0.0%");
        String formattedProfitPercentage = profitDecimal.format(profitPercentage / 100.0);
        OutputView.printScore(score);
        OutputView.printProfit(formattedProfitPercentage);
    }

    public WinningNumber inputWinningNumber() {
        OutputView.printEnterWinningNumber();
        List<Integer> numbers = InputView.inputLottoNumbers();

        OutputView.printEnterBonusNumber();
        int bonusNumber = InputView.inputBonusNumber();

        return new WinningNumber(new Lotto(numbers), bonusNumber);
    }



}
