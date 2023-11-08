package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    public String input(String printMessage) {
        System.out.println(printMessage);
        return Console.readLine();
    }

    public int getMoneyNumber(String purchaseMoney) {
        int moneyNumber = convertStringToInteger(purchaseMoney);
        if (moneyNumber % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return moneyNumber;
    }

    public List<Integer> convertStringToIntegerList(String input) {
        List<Integer> resultNumbers = new ArrayList<>();
        String[] inputNumbers = input.split(",");

        for (String inputNumber : inputNumbers) {
            int number = convertStringToInteger(inputNumber);
            resultNumbers.add(number);
        }
        return resultNumbers;
    }

    public Integer convertStringToInteger(String number) {
        return Integer.parseInt(number);
    }
}
