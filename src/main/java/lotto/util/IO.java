package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IO {
    public static void printNoticeln(String ment) {
        System.out.println(ment);
    }
    public static void printNotice(String ment) {
        System.out.print(ment);
    }

    public static Integer inputBudget() {
        String inputString= Console.readLine();
        int budget = Integer.parseInt(inputString);
        return budget;
    }
    public static List<Integer> inputWinningNumber() {
        String inputString= Console.readLine();
        String[] split = inputString.split(",");
        List<Integer> collect = Arrays.stream(split).map((a) -> Integer.parseInt(a)).collect(Collectors.toList());
        return collect;
    }

    public static Integer BonusNumber() {
        String inputString= Console.readLine();
        return Integer.parseInt(inputString);
    }


    public static void printLotto(List<Integer> lotto) {
        System.out.println(lotto.toString());
    }

}
