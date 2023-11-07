package lotto;

import lotto.domain.controller.LottoController;
import lotto.domain.controller.LottoServer;
import lotto.domain.controller.converter.LottosConverter;
import lotto.domain.controller.converter.StatisticsConverter;
import lotto.infra.RandomLottoGenerator;
import lotto.io.ConsoleInputReader;
import lotto.io.LottoInput;
import lotto.io.LottoOutput;

public class Application {
    public static void main(String[] args) {

        // 의존성 주입
        LottoController controller = new LottoController(
                new LottoInput(new ConsoleInputReader()),
                new LottoOutput(new LottosConverter(), new StatisticsConverter())
        );
        LottoServer server = new LottoServer(
                controller,
                new RandomLottoGenerator()
        );
        server.run();
    }
}
