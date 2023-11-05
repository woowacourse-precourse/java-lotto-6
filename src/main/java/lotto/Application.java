package lotto;

import lotto.domain.LottoAmountGenerator;

public class Application {
    static int amount;

    public static void main(String[] args) {
        amount = LottoAmountGenerator.generateLottoAmount();
        System.out.println(amount);
    }
}
