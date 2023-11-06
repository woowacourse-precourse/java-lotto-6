package lotto.domain;

import lotto.utils.Reader;

import java.util.Arrays;
import java.util.List;

public class Prompter {
    private static final String REGEX = ",";
    private static final int NO_LIMIT = -1;
    private final Messenger messenger;

    public Prompter(Messenger messenger) {
        this.messenger = messenger;
    }

    public Money promptMoney() {
        try {
            messenger.promptMoney();
            Money money = new Money(readInteger());
            messenger.newLine();
            return money;
        } catch (IllegalArgumentException e) {
            messenger.invalidMoneyError();
            messenger.newLine();
            return promptMoney();
        }
    }

    public WinningLotto promptWinningLotto() {
        try {
            messenger.promptWinningNumbers();
            List<Integer> winningNumbers = readIntegerList(REGEX, NO_LIMIT);
            Lotto lotto = new Lotto(winningNumbers);
            messenger.newLine();
            return promptBonusNumber(lotto);
        } catch (IllegalArgumentException e) {
            messenger.invalidWinningNumbersError();
            messenger.newLine();
            return promptWinningLotto();
        }
    }

    private WinningLotto promptBonusNumber(Lotto lotto) {
        try {
            messenger.promptBonusNumber();
            int bonusNumber = readInteger();
            WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
            messenger.newLine();
            return winningLotto;
        } catch (IllegalArgumentException e) {
            messenger.invalidBonusNumberError();
            messenger.newLine();
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
