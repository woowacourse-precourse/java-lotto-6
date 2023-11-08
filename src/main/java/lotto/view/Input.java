package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Input {

    Output output = new Output();

    public int getAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        validateAmount(amount);
        return amount;
    }

    private void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위 정수.");
        }
    }

    public List<Integer> getWinNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> ticket;
        while (true) {
            try {
                ticket = getNumbersFromString(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                output.printError(e);
            }
        }
        return ticket;
    }

    private List<Integer> getNumbersFromString(String str) {
        List<Integer> numbers = new ArrayList<>();
        String[] stringOfNumbers = str.split(",");
        for (String stringOfNumber : stringOfNumbers) {
            int number = Integer.parseInt(stringOfNumber);
            validateNumber(number);
            numbers.add(number);
        }
        return numbers;
    }

    private void validateNumber(int num) {
        if ((num <= 0) || (num > 45)) {
            throw new IllegalArgumentException("1 - 45 사이의 숫자.");
        }
    }

    public int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

}