package domain.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public static final String INPUT_MONEY_MSG = "구입금액을 입력해 주세요.";
    public static final String INPUT_NUMBER_MSG = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_MSG = "보너스 번호를 입력해 주세요.";

    public int inputMoney() {
        return promptReadInt(INPUT_MONEY_MSG);
    }

    public ArrayList<Integer> inputNumbers() {
        String numberLine = promptReadString(INPUT_NUMBER_MSG);

        List<Integer> numbersList = Arrays.stream(numberLine.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        return new ArrayList<Integer>(numbersList);
    }

    public int inputBonus() {
        return promptReadInt(INPUT_BONUS_MSG);
    }
    public int promptReadInt(String greeting) {
        System.out.println(greeting);
        return readInteger();
    }
    public String promptReadString(String greeting) {
        System.out.println(greeting);
        return Console.readLine();
    }

    public int readInteger(){
        String line = Console.readLine();
        int number;
        try {
            number = Integer.parseInt(line);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요!");
        }
        return number;
    }
}
