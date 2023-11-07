package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static String getInputNumber(){
        String money = Console.readLine();
        ValidationView.isDivided(money);
        ValidationView.isNumber(money);
        return money;
    }

    public static List<Integer> getWinningNumber(){
        String[] numbers = Console.readLine().split(",");
        ValidationView.checkConsecutiveCommas(numbers);
        List<Integer> winningNumbers = Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
        ValidationView.checkNumberSize(winningNumbers);
        ValidationView.checkInRange(winningNumbers);
        ValidationView.checkDuplicateNumbers(winningNumbers);
        return winningNumbers;
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        String bonus = Console.readLine();
        int bonusNumber = Integer.parseInt(bonus);
        ValidationView.checkBonusNumber(bonus, winningNumbers);
        ValidationView.checkInRangeNumber(bonus);
        return bonusNumber;
    }
}
