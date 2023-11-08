package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.exception.InvalidMoneyInput;
import lotto.exception.LackOfMoneyException;

public class UserLottoInput implements LottoInput {
    private final String DELIMITER = ",";

    @Override
    public int getMoneyAmount() {
        String input = Console.readLine();
        validateNumericString(input);
        int amount = Integer.parseInt(input);
        validateNotZero(amount);
        return amount;
    }

    @Override
    public Lotto getLotto() {
        List<LottoBall> winningLottoBalls = getNumbers()
                .stream()
                .map(LottoBall::new)
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
        return new LottoBall(number);
    }

    private void validateNumericString(String input) {
        for (Character c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InvalidMoneyInput();
            }
        }
    }

    private void validateNotZero(int amount) {
        if (amount == 0) {
            throw new LackOfMoneyException();
        }
    }
}
