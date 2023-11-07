package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.WinningNumbers;
import lotto.exception.InvalidMoneyInput;

public class UserLottoInput implements LottoInput {
    private final String DELIMITER = ",";

    @Override
    public long getMoneyAmount() {
        String input = Console.readLine();
        validateNumericString(input);
        return Long.parseLong(input);
    }

    @Override
    public WinningNumbers getWinningNumbers() {
        Lotto lotto = getLotto();
        LottoBall bonusBall = getBall();

        return new WinningNumbers(lotto, bonusBall);
    }

    private Lotto getLotto() {
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

    private LottoBall getBall() {
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
}
