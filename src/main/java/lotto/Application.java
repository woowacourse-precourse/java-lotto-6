package lotto;

import lotto.domain.PlayerLottoAmount;
import lotto.view.Inputview;

public class Application {
    public static void main(String[] args) {
        PlayerLottoAmount playerLottoAmount =
                new PlayerLottoAmount(Inputview.inputPurchaseAmount());

        int result = playerLottoAmount.calculateLottoCount();
        System.out.println("result = " + result);
    }
}
