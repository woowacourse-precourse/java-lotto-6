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
        int moneyNumber;
        try {
            moneyNumber = convertStringToInteger(purchaseMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 형식으로 입력해야 합니다.\n");
        }

        if (moneyNumber % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.\n");
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
