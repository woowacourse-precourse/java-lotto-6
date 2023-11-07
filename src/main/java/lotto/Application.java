package lotto;

import lotto.controller.LottoController;
import lotto.io.read.InputReader;
import lotto.io.write.OutputWriter;
import lotto.service.LottoInputReader;
import lotto.service.LottoOutputWriter;
import lotto.validation.LottoValidator;

public class Application {
    public static void main(String[] args) {
        LottoOutputWriter writer = LottoOutputWriter.of(new OutputWriter());
        LottoInputReader reader = LottoInputReader.of(new InputReader(), writer, new LottoValidator());

        LottoController controller = LottoController.of(reader, writer);
        controller.handle();
    }
}
