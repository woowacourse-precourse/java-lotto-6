package lotto.controller;

import lotto.domain.Lotto;
import lotto.view.Message;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.utils.Reader;

import java.util.Arrays;
import java.util.List;

public class Prompter {
    private static final String REGEX = ",";
    private static final int NO_LIMIT = -1;
    private final Message message;

    public Prompter(Message message) {
        this.message = message;
    }

    public Money promptMoney() {
        try {
            message.promptMoney();
            Money money = new Money(readInteger());
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
            List<Integer> winningNumbers = readIntegerList(REGEX, NO_LIMIT);
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
            int bonusNumber = readInteger();
            WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
            message.newLine();
            return winningLotto;
        } catch (IllegalArgumentException e) {
            message.invalidBonusNumberError();
            message.newLine();
            return promptBonusNumber(lotto);
        }
    }

    private int readInteger() {
        String input = Reader.readLine().strip();
        return Integer.parseInt(input);
    }

    private List<Integer> readIntegerList(String regex, int limit) {
        String input = Reader.readLine();

        List<Integer> numbers = Arrays.stream(input.split(regex, limit))
                .map(String::strip)
                .map(Integer::parseInt)
                .toList();

        return numbers;
    }
}
