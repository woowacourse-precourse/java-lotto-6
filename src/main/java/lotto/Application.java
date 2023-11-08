package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController();
        controller.run();
        Console.close();
    }
}
