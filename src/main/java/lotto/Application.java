package lotto;

import lotto.domain.Lotto;
import lotto.domain.Numbers;
import lotto.domain.Purchase;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Numbers numbers = new Numbers();
        Purchase purchase = new Purchase();

        int inputPurchaseAmount = purchase.inputPurchaseAmount();
        int round = purchase.calculateRound(inputPurchaseAmount);

        for (int i = 0; i < round; i++) {
            numbers.createLottoNumbers();
        }
        System.out.println();

        List<Integer> luckyNumbers= numbers.inputLuckyNumbers();
        Lotto lotto = new Lotto(luckyNumbers);

        int bonusNumber = numbers.inputBonusNumber();
    }
}
