package lotto;

import lotto.domain.LottoServer;
import lotto.domain.LottosConverter;
import lotto.domain.StatisticsConverter;
import lotto.infra.RandomLottoGenerator;
import lotto.io.LottoInput;
import lotto.io.LottoOutput;

public class Application {
    public static void main(String[] args) {
        LottoServer server = new LottoServer(
                new LottoInput(),
                new LottoOutput(new LottosConverter(), new StatisticsConverter()),
                new RandomLottoGenerator()
        );
        server.run();
    }
}
