package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String inputPurchaseAmount = InputLotto.PurchaseAmount();

        Lotto.validateAmount(inputPurchaseAmount);

        int purchaseAmount = OutputLotto.purchaseAmount(inputPurchaseAmount);

        int purchaseNumber = OutputLotto.purchaseNumber(purchaseAmount);

        List<List<Integer>> saveLottoNumbers = OutputLotto.makeLottoNumbers(purchaseNumber);

        String inputWinningNumber = InputLotto.winningNumber();

        List<Integer> numbers = InputLotto.saveNumbers(inputWinningNumber);

        Lotto lotto = new Lotto(numbers);

        int bonusNumber = InputLotto.bonusNumber();

        Calculation calculation = Calculation.winningStatistics(saveLottoNumbers, numbers, bonusNumber);

        int bonusMatchCount = calculation.getBonusMatchCount();
        int[] matchCounts = calculation.getMatchCounts();

        OutputLotto.winningResult(bonusMatchCount, matchCounts);

        int winningAmount = Calculation.winningAmount(matchCounts);

        OutputLotto.rateOfReturn(winningAmount, purchaseAmount);

    }
}
