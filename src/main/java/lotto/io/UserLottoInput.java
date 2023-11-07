package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.WinningNumbers;
import lotto.exception.InvalidMoneyInput;
import lotto.exception.LottoIllegalArgumentException;

public class UserLottoInput implements LottoInput {
    private final String DELIMITER = ",";

    @Override
    public int getMoneyAmount() {
        String input = Console.readLine();
        validateNumericString(input);
        int amount = Integer.parseInt(input);
        validateRange(amount);
        return amount;
    }

    private WinningNumbers getWinningNumbers() {
        Lotto lotto = getLotto();
        LottoBall bonusBall = getBall();

        return new WinningNumbers(lotto, bonusBall);
    }

    @Override
    public Lotto getLotto() {
        List<LottoBall> winningLottoBalls = getNumbers()
                .stream()
                .map(LottoBall::getInstance)
                .toList();

        return new Lotto(winningLottoBalls);
    }

    private List<Integer> getNumbers() {
        String input = Console.readLine();
        String[] numbersInput = input.split(DELIMITER);

        Arrays.stream(input.split(DELIMITER))
                .forEach(this::validateNumericString);

        return Arrays.stream(numbersInput)
                .map(Integer::parseInt)
                .toList();
    }

    @Override
    public LottoBall getBall() {
        String input = Console.readLine();
        validateNumericString(input);
        int number = Integer.parseInt(input);
        return LottoBall.getInstance(number);
    }

    private void validateNumericString(String input) {
        for (Character c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InvalidMoneyInput();
            }
        }
    }

    private void validateRange(int amount) {
        if (amount <= 0) {
            throw new InvalidMoneyInput();
        }
    }
}
