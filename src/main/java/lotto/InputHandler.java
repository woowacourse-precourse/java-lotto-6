package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static Integer getUserInputAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        String input = Console.readLine();
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
        return number;
    }

    public static List<Integer> getUserInputlotto() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요");

        String input = Console.readLine();

        String[] inputData = input.split(",");
        List<Integer> inputList = new ArrayList<>();

        for (String data : inputData) {
            try {
                int number = Integer.parseInt(data.trim());
                inputList.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
            }
        }
        return inputList;
    }

    public static Integer getUserInputBonus() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요");

        String input = Console.readLine();
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
        return number;
    }
}
