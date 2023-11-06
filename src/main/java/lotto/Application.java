package lotto;

import lotto.controller.Parser;
import lotto.controller.Reader;
import lotto.domain.Game;
import lotto.view.Message;
import lotto.view.MessageBuilder;
import lotto.view.WriterMessenger;
import lotto.controller.Prompt;
import lotto.controller.ConsoleReader;

public class Application {
    public static void main(String[] args) {
        try (Reader reader = new ConsoleReader()) {
            Message message = new Message(new WriterMessenger(), new MessageBuilder());
            Prompt prompt = new Prompt(reader, new Parser(), message);
            Game game = new Game(message, prompt);

            game.joinPlayer();
            game.showIssuedLottos();
            game.generateWinningLotto();
            game.calculateResult();
            game.showResult();
        }
    }
}
