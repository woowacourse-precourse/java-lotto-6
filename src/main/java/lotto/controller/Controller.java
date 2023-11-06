package lotto.controller;

import java.util.HashMap;
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
        part1();
        Lotties lotties = part2();
        WinningNumber winningNumber = part3();


    }


    public void part1() {
        OutputView.printBuyInputPrice();
        int userPrice = InputView.inputUserPrice();
        lottoCnt = userPrice / 1000;
        OutputView.printBuyLottoCount(lottoCnt);
    }

    public Lotties part2() {
        Lotties lotties = LottoFactory.generateLotties(lottoCnt);
        OutputView.pritntLottos(lotties.getLottiesNumbers());
        return lotties;
    }

    public WinningNumber part3() {
        OutputView.printEntertWinningNumber();
        List<Integer> numbers = InputView.inputLottoNumbers();

        OutputView.printEnterBounsNumber();
        int bonusNumber = InputView.inputBonusNumber();

        return new WinningNumber(new Lotto(numbers), bonusNumber);
    }

    public Result getResult(Lotto lotto, WinningNumber winningNumber) {
        int bonusNumber = winningNumber.getBonusNumber();
        int matchCnt = 0;
        boolean isBonusMatched = false;
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningLottoNumbers = winningNumber.getLottoNumbers();

        for (Integer number : numbers) {
            if (winningLottoNumbers.contains(number)) {
                matchCnt++;
            }
        }

        isBonusMatched = numbers.contains(bonusNumber);

        if (matchCnt == 6) {
            return Result.SIX_MATCH;
        }

        if (matchCnt == 5 && isBonusMatched) {
            return Result.FIVE_AND_BONUS_MATCH;
        }
        if (matchCnt == 5) {
            return Result.FIVE_MATCH;
        }
        if (matchCnt == 4) {
            return Result.FOUR_MATCH;
        }
        if (matchCnt == 3) {
            return Result.THREE_MATCH;
        }
        return Result.NOTHING;
    }


}
