package lotto.view;

import lotto.controller.OutputController;
import lotto.model.Lotto;
import lotto.model.Model;

import java.util.List;

public class OutputView {
    private final OutputController outputController;

    public OutputView(Model model, Lotto lotto) {
        this.outputController = new OutputController(model, lotto);
    }

    public void start() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
