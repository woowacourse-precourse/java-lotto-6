package lotto;

import lotto.domain.LottoServer;

public class Application {
    public static void main(String[] args) {
        LottoServer server = new LottoServer();
        server.run();
    }
}
