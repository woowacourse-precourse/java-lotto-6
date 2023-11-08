package lotto;

import java.util.Comparator;
import lotto.controller.LottoController;
import lotto.model.generator.QuickPick;
import lotto.view.InputViewImpl;
import lotto.view.OutputViewImpl;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.of(new InputViewImpl(), new OutputViewImpl());
        lottoController.runLottoStore(new QuickPick(), Comparator.naturalOrder());
    }
}
