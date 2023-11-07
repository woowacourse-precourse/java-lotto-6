package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static Integer getUserInputAmount() throws IllegalArgumentException{

        String input = Console.readLine();
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
        return number;
    }

    public static List<Integer> getUserInputlotto() throws IllegalArgumentException{

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

    public static Integer getUserInputBonus() throws IllegalArgumentException{

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
