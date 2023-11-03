package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.BuyingLottoController;

public class Application {
    public static void main(String[] args) {
        BuyingLottoController buyingController = new BuyingLottoController();
        Console.close();
    }
}
