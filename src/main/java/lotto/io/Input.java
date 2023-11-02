package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {

    public int getMoney() {
        String userInput = Console.readLine();
        try {
            validateOnlyNumber(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            getMoney();
        }
        return Integer.parseInt(userInput);
    }

    private void validateOnlyNumber(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if(!(userInput.charAt(i) >= '0' && userInput.charAt(i) <= '9')) {
                throw new IllegalArgumentException("[ERROR]");
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        List<String> numbers = List.of(Console.readLine().split(","));
        return numbers.stream().mapToInt(Integer::parseInt).boxed().toList();
    }

    public int getBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
