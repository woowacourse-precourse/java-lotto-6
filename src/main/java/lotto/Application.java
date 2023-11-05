package lotto;

import lotto.domain.LottoServer;
import lotto.io.LottoInput;
import lotto.io.LottoOutput;

public class Application {
    public static void main(String[] args) {
        LottoServer server = new LottoServer(new LottoInput(), new LottoOutput());
        server.run();
    }
}
