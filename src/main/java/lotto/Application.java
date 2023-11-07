package lotto;

import lotto.Controller.Controller;
import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Application {
    static Controller controller = new Controller(InputView.getInstance(), OutputView.getInstance(), new LottoService());
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        controller.run();
    }
}
