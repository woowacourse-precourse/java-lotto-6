package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(String[] numbersInput, int bonusNumber) {
        super(parseNumbers(numbersInput));
        if (getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public boolean isBonusNumber(int number) {
        return number == bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static List<Integer> parseNumbers(String[] numbersInput) {
        return Arrays.stream(numbersInput)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


}
