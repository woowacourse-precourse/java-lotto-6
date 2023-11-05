package lotto.domain.lottery;

import java.util.List;

public class JackpotNumber {
    private static final boolean BONUS = true;
    private static final boolean NORMAL = false;

    private final int number;
    private final boolean isBonus;

    private JackpotNumber(
            int number,
            boolean isBonus
    ) {
        this.number = number;
        this.isBonus = isBonus;
    }

    public static List<JackpotNumber> createNormalJackpotNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .map(JackpotNumber::createNormalJackpotNumber)
                .toList();
    }

    private static JackpotNumber createNormalJackpotNumber(final int number) {
        return new JackpotNumber(number, NORMAL);
    }

    public static JackpotNumber createBonusJackpotNumber(final int number) {
        return new JackpotNumber(number, BONUS);
    }

    public int getNumber() {
        return number;
    }
}
