package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoInputReader;
import lotto.service.LottoOutputWriter;
import lotto.validation.LottoValidator;
import lotto.view.read.InputView;
import lotto.view.write.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoOutputWriter writer = LottoOutputWriter.of(new OutputView());
        LottoInputReader reader = LottoInputReader.of(new InputView(), writer, new LottoValidator());

        LottoController controller = LottoController.of(reader, writer);
        controller.run();
    }
}
