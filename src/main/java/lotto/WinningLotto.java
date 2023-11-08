package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

public class WinningLotto {

    static Lotto winningLotto;
    static int bonusNumber;

    static public void gettingWinningNumbers() {
        System.out.println(InputType.WINNINGNUMBER.getInputMessage());
        String input = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        createLotto(winningNumbers);
    }

    static public void createLotto(List<Integer> winningNumbers) {
        try {
            winningLotto = new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            gettingWinningNumbers();
        }
    }

    static public void gettingBonusNumber() {
        System.out.println(InputType.BONUSNUMBER.getInputMessage());
        String input = Console.readLine();
        bonusNumber = Integer.parseInt(input);
        validateBonusNumber();
    }

    static public void validateBonusNumber() {
        try {
            if (bonusNumber < 1 | bonusNumber > 45) {
                throw new IllegalArgumentException(ErrorType.RANGE.getErrorMessage());
            }
            if (winningLotto.getNumbers().contains(bonusNumber)) {
                throw new IllegalArgumentException(ErrorType.REPITITION.getErrorMessage());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            gettingBonusNumber();
        }
    }
}
