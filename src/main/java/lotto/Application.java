package lotto;

import lotto.domain.Numbers;

public class Application {
    public static void main(String[] args) {

        Numbers numbers = new Numbers();

        int inputPurchaseAmount = numbers.inputPurchaseAmount();
        int round = numbers.calculateRound(inputPurchaseAmount);

        for (int i = 0; i < round; i++) {
            numbers.createLottoNumbers();
        }
    }
}
