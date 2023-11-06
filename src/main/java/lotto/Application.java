package lotto;

import lotto.io.ConsoleReader;
import lotto.io.ConsoleWriter;
import lotto.repository.LottoRepository;
import lotto.view.LottoScreen;

public class Application {
    public static void main(String[] args) {
        LottoApplication lottoApplication = new LottoApplication(
                new LottoScreen(new ConsoleReader(), new ConsoleWriter()), new LottoRepository());
        lottoApplication.run();
    }
}
