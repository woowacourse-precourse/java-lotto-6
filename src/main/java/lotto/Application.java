package lotto;

import lotto.domain.Game;
import lotto.view.Message;
import lotto.view.MessageBuilder;
import lotto.view.WriterMessenger;
import lotto.controller.Prompter;
import lotto.utils.Reader;

public class Application {
    public static void main(String[] args) {
        try {
            Message message = new Message(new WriterMessenger(), new MessageBuilder());
            Prompter prompter = new Prompter(message);
            Game game = new Game(message, prompter);

            game.joinPlayer();
            game.showIssuedLottos();
            game.generateWinningLotto();
            game.calculateResult();
            game.showResult();
        } finally {
            Reader.close();
        }
    }
}
