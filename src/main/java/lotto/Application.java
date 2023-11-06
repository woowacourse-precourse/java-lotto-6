package lotto;

import lotto.Controller.ProcessLotto;
import lotto.Controller.ValidateTools;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ProcessLotto processLotto = new ProcessLotto(new InputView(), new OutputView());
        processLotto.drawLotto(new ValidateTools());

    }
}
