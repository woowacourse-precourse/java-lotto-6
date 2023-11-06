package lotto.domain;

import lotto.utils.Reader;
import lotto.utils.Writer;

import java.util.Arrays;
import java.util.List;

public class Prompter {
    private static final String REGEX = ",";
    private static final int NO_LIMIT = -1;

    public Money promptMoney() {
        try {
            Writer.promptMoney();
            Money money = new Money(readInteger());
            Writer.newLine();
            return money;
        } catch (IllegalArgumentException e) {
            Writer.invalidMoneyError();
            Writer.newLine();
            return promptMoney();
        }
    }

    public WinningLotto promptWinningLotto() {
        try {
            Writer.promptWinningNumbers();
            List<Integer> winningNumbers = readIntegerList(REGEX, NO_LIMIT);
            Lotto lotto = new Lotto(winningNumbers);
            Writer.newLine();
            return promptBonusNumber(lotto);
        } catch (IllegalArgumentException e) {
            Writer.invalidWinningNumbersError();
            Writer.newLine();
            return promptWinningLotto();
        }
    }

    private WinningLotto promptBonusNumber(Lotto lotto) {
        try {
            Writer.promptBonusNumber();
            int bonusNumber = readInteger();
            WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
            Writer.newLine();
            return winningLotto;
        } catch (IllegalArgumentException e) {
            Writer.invalidBonusNumberError();
            Writer.newLine();
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
