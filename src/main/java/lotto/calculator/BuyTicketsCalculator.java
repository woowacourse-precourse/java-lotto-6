package lotto.calculator;

import static lotto.constants.ConstantValues.LOTTO_COST;

public class BuyTicketsCalculator {

        public static int getLottoListSize(int money) {
            return money / LOTTO_COST.getValue();
        }

}
