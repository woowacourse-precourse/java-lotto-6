package lotto;

import camp.nextstep.edu.missionutils.Console;
import controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final LottoController lottoController = new LottoController();
        lottoController.run();
        Console.close();
    }
}
