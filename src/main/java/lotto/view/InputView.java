package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.NumValidator.*;
import static lotto.view.Message.*;

public class InputView {


    private static List<Integer> winningNumbers;

    public static String inputPlayerAmount() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Console.readLine();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        return convertToList(Console.readLine());

    }

    private static List<Integer> convertToList(String inputNumbers) {
        String[] result = inputNumbers.split(",");
        winningNumbers = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            int num = checkNumber(result[i]);
            checkRange(num);
            winningNumbers.add(num);
        }
        checkCntNumber(winningNumbers);
        return winningNumbers;
    }


    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        int num = checkNumber(input);
        checkRange(num);
        return num;
    }


}
