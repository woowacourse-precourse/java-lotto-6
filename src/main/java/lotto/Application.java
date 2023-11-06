package lotto;

import lotto.domain.Game;
import lotto.domain.LottoMachine;
import lotto.domain.Messenger;
import lotto.domain.Prompter;
import lotto.utils.Reader;

public class Application {
    public static void main(String[] args) {
        try {
            Messenger messenger = new Messenger();
            Prompter prompter = new Prompter(messenger);
            LottoMachine lottoMachine = new LottoMachine();
            Game game = new Game(prompter, lottoMachine, messenger);

            game.joinPlayer();
            game.printIssuedLottos();
            game.generateWinningLotto();
            game.calculateResult();
            game.printResult();
        } finally {
            Reader.close();
        }
    }
}
