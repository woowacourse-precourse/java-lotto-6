package lotto;

import lotto.controller.LottoController;
import lotto.strategy.NumberGenerationStrategy;
import lotto.strategy.RandomNumberStrategy;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.Input;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output output = new ConsoleOutputView();
        Input input = new ConsoleInputView();
        NumberGenerationStrategy numberGenerationStrategy = new RandomNumberStrategy();
        LottoController lottoController = new LottoController(numberGenerationStrategy,input,output);
        lottoController.run();
    }
}
