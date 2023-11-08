package lotto;

import lotto.controller.LottoController;
import lotto.domain.lotto.Lotto;
import lotto.io.ConsoleInput;
import lotto.io.Output;
import lotto.view.LottoView;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new LottoView(new ConsoleInput(), new Output()));
        try {
            lottoController.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
