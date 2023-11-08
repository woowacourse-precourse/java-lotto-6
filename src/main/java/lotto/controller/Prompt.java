package lotto.controller;

import lotto.domain.Lotto;
import lotto.view.Message;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

import java.util.List;

public class Prompt {
    private final Reader reader;
    private final PromptParser parser;
    private final Message message;

    public Prompt(Reader reader, PromptParser parser, Message message) {
        this.reader = reader;
        this.parser = parser;
        this.message = message;
    }

    public Money promptMoney() {
        try {
            message.promptMoney();
            String input = reader.readLine().strip();
            Money money = new Money(parser.integer(input));
            message.newLine();
            return money;
        } catch (IllegalArgumentException e) {
            message.invalidMoneyError();
            message.newLine();
            return promptMoney();
        }
    }

    public WinningLotto promptWinningLotto() {
        try {
            message.promptWinningNumbers();
            String input = reader.readLine().strip();
            List<Integer> winningNumbers = parser.integerList(input);
            Lotto lotto = new Lotto(winningNumbers);
            message.newLine();
            return promptBonusNumber(lotto);
        } catch (IllegalArgumentException e) {
            message.invalidWinningNumbersError();
            message.newLine();
            return promptWinningLotto();
        }
    }

    private WinningLotto promptBonusNumber(Lotto lotto) {
        try {
            message.promptBonusNumber();
            String input = reader.readLine().strip();
            int bonusNumber = parser.integer(input);
            WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
            message.newLine();
            return winningLotto;
        } catch (IllegalArgumentException e) {
            message.invalidBonusNumberError();
            message.newLine();
            return promptBonusNumber(lotto);
        }
    }
}
