package lotto.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Result;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private int lottoCnt;


    public void run() {
        Map<Result,Integer> score = new HashMap<>();
        part1();
        Lotties lotties = part2();
        WinningNumber winningNumber = part3();

        for(Lotto lotto : lotties.getLotties()){
            Result result = findResult(lotto,winningNumber);
            int resultCnt = score.getOrDefault(result,0);
            score.put(result,resultCnt + 1);
        }

        OutputView.printScore(score);

    }


    public void part1() {
        OutputView.printBuyInputPrice();
        int userPrice = InputView.inputUserPrice();
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

    public Result findResult(Lotto lotto, WinningNumber winningNumber) {
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