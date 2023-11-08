package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoMainController;

public class Application {
    public static void main(String[] args) {
        LottoMainController.start();
        Console.close();
    }
}
