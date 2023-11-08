package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private InputView() {
    }

    public static String inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static List<Integer> inputprizeNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseNumbers(input);
    }

    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = Console.readLine();
        return parseSingleNumber(input);
    }

    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int parseSingleNumber(String input) {
        return Integer.parseInt(input.trim());
    }


}