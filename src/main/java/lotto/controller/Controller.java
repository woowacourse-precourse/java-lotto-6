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
    private int lottoCnt;
    private int userPrice;
    private final int LOTTO_PRICE =1000;


    public void run() {
        Map<Result, Integer> score = new HashMap<>();
        int totalProfit = 0;
        int totalInvestment = 0;

        init();

        UserPrice userPrice = new UserPrice(InputView.inputUserPrice());
        lottoCnt = userPrice.buyCount(LOTTO_PRICE);

        Lotties lotties = part2();
        WinningNumber winningNumber = part3();

        for (Lotto lotto : lotties.getLotties()) {
            Result result = getResult(lotto, winningNumber);
            int resultCnt = score.getOrDefault(result, 0);
            score.put(result, resultCnt + 1);
        }


        for (Result result : score.keySet()) {
            totalProfit += result.getWinnings() * score.get(result);
        }

        double profitPercentage = (totalProfit) / (double) totalInvestment * 100;
        DecimalFormat profitDecimal = new DecimalFormat("#0.0%");
        String formattedProfitPercentage = profitDecimal.format(profitPercentage / 100.0);
        OutputView.printScore(score);
        OutputView.printProfit(formattedProfitPercentage);
    }


    public void init() {
        OutputView.printBuyInputPrice();
        userPrice = InputView.inputUserPrice();
        lottoCnt = userPrice / 1000;
        OutputView.printBuyLottoCount(lottoCnt);
    }

    public Lotties part2() {
        Lotties lotties = LottoFactory.generateLotties(lottoCnt);
        OutputView.printLotties(lotties.getLottiesNumbers());
        return lotties;
    }

    public WinningNumber part3() {
        OutputView.printEnterWinningNumber();
        List<Integer> numbers = InputView.inputLottoNumbers();

        OutputView.printEnterBonusNumber();
        int bonusNumber = InputView.inputBonusNumber();

        return new WinningNumber(new Lotto(numbers), bonusNumber);
    }

    private Result getResult(Lotto lotto, WinningNumber winningNumber) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningLottoNumbers = winningNumber.getLottoNumbers();
        int bonusNumber = winningNumber.getBonusNumber();
        int matchCount = 0;
        for(int number : numbers) {
            if(winningLottoNumbers.contains(number)) {
                matchCount++;
            }
        }
        boolean isBonusMatched = numbers.contains(bonusNumber);
        return Result.find(matchCount, isBonusMatched);
    }

}
