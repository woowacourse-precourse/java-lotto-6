package lotto;

import lotto.controller.LottoController;
import util.Printer.Printer;
import util.Scanner.Scanner;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView(new Scanner());
        OutputView outputView = new OutputView(new Printer());
        LottoController lottoController = new LottoController(inputView, outputView);
        lottoController.play();

    }
}
