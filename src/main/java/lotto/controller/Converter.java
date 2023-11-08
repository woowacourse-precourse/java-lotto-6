package lotto.controller;

import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.money.Wallet;

import java.util.Arrays;
import java.util.List;

public class Converter {

    private Converter() {
    }

    public static Wallet stringToWallet(String userInput) {
        return new Wallet(validInteger(userInput));
    }

    public static Lotto stringToLotto(String userInput) {
        List<Integer> numbers = Arrays.stream(userInput.split(","))
                .map(String::trim)
                .map(Converter::validInteger)
                .toList();

        return new Lotto(numbers);
    }

    public static Bonus stringToBonus(String userInput, Lotto lotto) {
        int bonus = validInteger(userInput);

        validDuplicate(lotto, bonus);

        return new Bonus(validInteger(userInput));
    }

    private static void validDuplicate(Lotto lotto, int bonus) {
        if (lotto.isContainsBonus(bonus)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }

    private static int validInteger(String userInput) {
        try {
            return Integer.parseInt(userInput);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력이 가능합니다.");
        }
    }
}
