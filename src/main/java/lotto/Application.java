package lotto;

import lotto.domain.LottoServer;
import lotto.domain.LottosConverter;
import lotto.domain.StatisticsConverter;
import lotto.infra.RandomLottoGenerator;
import lotto.io.ConsoleInputReader;
import lotto.io.LottoInput;
import lotto.io.LottoOutput;

public class Application {
    public static void main(String[] args) {

        // 의존성 주입
        LottoServer server = new LottoServer(
                new LottoInput(new ConsoleInputReader()),
                new LottoOutput(new LottosConverter(), new StatisticsConverter()),
                new RandomLottoGenerator()
        );
        server.run();
    }
}
