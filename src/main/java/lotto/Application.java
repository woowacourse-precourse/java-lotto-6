package lotto;

import lotto.controller.LottoController;
import lotto.util.Printer.Printer;
import lotto.util.Scanner.Scanner;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView(new Scanner());
        OutputView outputView = new OutputView(new Printer());
        LottoController lottoController = new LottoController(inputView, outputView);
        lottoController.play();

    }

}
