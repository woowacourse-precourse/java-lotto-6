package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

import static lotto.util.GameMessage.*;

public class InputView {

    public static int getAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE.getMessage());

        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> getLuckyNumber() {
        System.out.println(INPUT_LUCKY_NUMBER_MESSAGE.getMessage());
        String[] inputNumbers = Console.readLine().split(",");
        List<Integer> winningNumber = new ArrayList<>();

        for (String number : inputNumbers) {
            winningNumber.add(Integer.parseInt(number));
        }

        return winningNumber;
    }

    public static int getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE.getMessage());

        return Integer.parseInt(Console.readLine());
    }
}
