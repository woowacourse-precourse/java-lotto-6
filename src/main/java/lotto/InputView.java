package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {

    public static void printInsertMoney() {
        System.out.println(InputConstants.ENTER_MONEY.getMessage());
    }

    public int insertMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public static void printInsertLottoNumbers() {
        System.out.println(InputConstants.ENTER_LOTTO_NUMBERS.getMessage());
    }

    public ArrayList<Integer> insertLottoNumbers() {
        String input = Console.readLine();
        ArrayList<String> inputList = new ArrayList<>(Arrays.asList(input.split(",")));
        return inputList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void printBonusNumber() {
        System.out.println(InputConstants.ENTER_BONUS_NUMBER.getMessage());
    }

    public int insertBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
