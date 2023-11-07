package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현]
        LottoController controller=new LottoController(new InputView(),new OutputView());
        controller.lottoStart();
        Console.close();
    }
}
