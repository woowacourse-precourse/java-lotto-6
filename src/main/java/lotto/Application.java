package lotto;

import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.Numbers;
import lotto.domain.Purchase;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Numbers numbers = new Numbers();
        Purchase purchase = new Purchase();
        Calculator calculator = new Calculator();

        int inputPurchaseAmount = purchase.inputPurchaseAmount();
        int round = purchase.calculateRound(inputPurchaseAmount);

        List<Integer> lottoNumbers = numbers.addLottoNumbers(round);
        System.out.println();

        List<Integer> luckyNumbers = numbers.inputLuckyNumbers();
        Lotto lotto = new Lotto(luckyNumbers);

        int bonusNumber = numbers.inputBonusNumber();

        List<Integer> countOfMatch = calculator.countCorrectLuckyNumbers(lottoNumbers, luckyNumbers, bonusNumber);

        List<Integer> countRanking = calculator.countRanking(countOfMatch);

        calculator.printResult(countRanking);

        calculator.rateOfReturn(inputPurchaseAmount, countRanking);
    }
}