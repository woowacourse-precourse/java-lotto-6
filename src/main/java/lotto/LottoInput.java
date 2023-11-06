package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoInput {
    public static int inputLottoPrice() {
        String input = Console.readLine();
        validateLottoPrice(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> inputWinningNum() {
        String input = Console.readLine();
        validateinputWinnigNum(input);
        return stringToIntList(input);
    }

    public static int inputBonusNum() {
        String input = Console.readLine();
        validateWinningNumRange(input,45);
        return Integer.parseInt(input);
    }

    public static void validateLottoPrice(String input) {
        int inputNum = Integer.parseInt(input);
        if (inputNum % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]값이 천원단위가 아닙니다.");
        }
    }

    public static void validateinputWinnigNum(String input) {
        validateWinningNumCount(input);
        validateWinningNumRange(input, 45);
        validateWinningtNumRedundant(input);
    }


    public static void validateWinningNumCount(String input) {
        int length = input.split(",").length;
        if (length != 6) {
            throw new IllegalArgumentException("[ERROR]당첨번호는 6개입니다");
        }
    }

    public static void validateWinningNumRange(String input, int range) {
        List<Integer> WinningNum = stringToIntList(input);

        for (int num : WinningNum) {
            if (num < 1 || num > range) {
                throw new IllegalArgumentException("[ERROR]당첨번호는 1~45사이의 수 입니다.");
            }
        }
    }

    public static void validateWinningtNumRedundant(String input) {
        String[] winningVal = input.split(",");
        Set<String> redundantRemove = new HashSet<>();
        for (String winNum : winningVal) {
            if (!redundantRemove.add(winNum)) {
                throw new IllegalArgumentException("[Error]당첨번호는 중복되지않은 숫자 6개입니다.");
            }
        }
    }

    public static List<Integer> stringToIntList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
