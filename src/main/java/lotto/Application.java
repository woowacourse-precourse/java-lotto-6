package lotto;

import lotto.game.LottoGameController;
import lotto.reader.ConsoleReader;
import lotto.writer.ConsoleWriter;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGameController lottoGameController = new LottoGameController(new ConsoleReader(),
            new ConsoleWriter());
        lottoGameController.play();
    }
}
