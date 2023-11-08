package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.Money;
import lotto.exception.common.CustomArgumentException;
import lotto.exception.input.NotIntegerException;

public class InputView {
    public Money payMoney() {
        String input = Console.readLine();
        verifyInteger(input);
        int value = Integer.parseInt(input);
        return new Money(value);
    }

    public List<Integer> enterWinningLottoNumbers() {
        while (true) {
            try {
                String input = Console.readLine();
                String[] splited = input.split(",");
                return Arrays.stream(splited)
                        .peek(this::verifyInteger)
                        .map(Integer::parseInt)
                        .toList();
            } catch (CustomArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int enterBonusNumber() {
        while (true) {
            try {
                String input = Console.readLine();
                verifyInteger(input);
                return Integer.parseInt(input);
            } catch (CustomArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void verifyInteger(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new NotIntegerException();
        }
    }
}
