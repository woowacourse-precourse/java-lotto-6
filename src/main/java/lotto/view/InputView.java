package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static String getInputNumber(){
        String money = Console.readLine();
        ValidationView.isDivided(money);
        return money;
    }

    public static List<Integer> getWinningNumber(){
        String[] numbers = Console.readLine().split(",");
        ValidationView.checkConsecutiveCommas(numbers);
        List<Integer> winningNumbers = Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
        ValidationView.checkNumberSize(winningNumbers);
        ValidationView.checkInRange(winningNumbers);
        ValidationView.checkDuplicateNumbers(winningNumbers);
        System.out.println();
        return winningNumbers;
    }
}
