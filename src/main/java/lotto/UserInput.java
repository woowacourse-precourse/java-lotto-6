package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class UserInput {
    public int insertMoney(String prompt){
        System.out.println(prompt);

        String userInput = Console.readLine();
        int insertedMoney = Integer.parseInt(userInput);

        return (insertedMoney/1000);
    }

    public List<Integer> inputWinnerNumbers(String prompt) {
        System.out.println(prompt);

        String userInput = Console.readLine();
        String[] splitStrings = userInput.split(",");
        List<Integer> resultList = new ArrayList<>();
        for (String str : splitStrings) {
            int num = Integer.parseInt(str.trim());
            resultList.add(num);
        }
        return resultList;
    }

    public int inputBonusNumber(String prompt) {
        System.out.println(prompt);
        String userInput = Console.readLine();
        int bonusNumber = Integer.parseInt(userInput);

        return bonusNumber;
    }
}
