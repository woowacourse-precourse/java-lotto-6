package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.exception.InvalidRangeInputException;
import lotto.exception.InvalidInputException;

public class UserLottoInput implements LottoInput {
    private final String DELIMITER = ",";

    @Override
    public int getMoneyAmount() {
        String input = Console.readLine();
        validateMoneyAmount(input);
        return Integer.parseInt(input);
    }

    private void validateMoneyAmount(String input) {
        validateInteger(input);
        validatePositive(input);
    }

    private void validatePositive(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new InvalidRangeInputException();
        }
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

        Arrays.stream(numbersInput)
                .forEach(this::validateInteger);

        return Arrays.stream(numbersInput)
                .map(Integer::parseInt)
                .toList();
    }

    @Override
    public LottoBall getBall() {
        String input = Console.readLine();
        validateInteger(input);

        int number = Integer.parseInt(input);
        return new LottoBall(number);
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException();
        }
    }

}
