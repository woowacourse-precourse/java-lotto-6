package lotto;

import lotto.controller.PromptParser;
import lotto.controller.Reader;
import lotto.domain.Game;
import lotto.domain.LottoMachine;
import lotto.view.Message;
import lotto.view.MessageBuilder;
import lotto.view.WriterMessenger;
import lotto.controller.Prompt;
import lotto.controller.ConsoleReader;

public class Application {
    public static void main(String[] args) {
        try (Reader reader = new ConsoleReader()) {
            Message message = new Message(new WriterMessenger(), new MessageBuilder());
            Prompt prompt = new Prompt(reader, new PromptParser(), message);
            Game game = new Game(message, prompt, new LottoMachine());
            game.run();
        }
    }
}
