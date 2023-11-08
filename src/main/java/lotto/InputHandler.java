package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static Integer getUserInputAmount() throws IllegalArgumentException{

        String input = Console.readLine();
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
        return amount;
    }

    public static List<Integer> getUserInputlotto() throws IllegalArgumentException{

        String input = Console.readLine();

        String[] inputs = input.split(",");
        List<Integer> lottoNums = new ArrayList<>();

        for (String element : inputs) {
            try {
                int lotto = Integer.parseInt(element.trim());
                lottoNums.add(lotto);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
            }
        }
        return lottoNums;
    }

    public static Integer getUserInputBonus() throws IllegalArgumentException{

        String input = Console.readLine();
        int bonus;
        try {
            bonus = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
        return bonus;
    }
}
