package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public int getUserAmount() {
        String userInput = Console.readLine();
        validateUserInput(userInput);
        return Integer.parseInt(userInput);
    }

    private void validateUserInput(String userInput) {
        validateOnlyNumbers(userInput);
        validateDivisibleByThousand(userInput);
    }

    private void validateOnlyNumbers(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if(!Character.isDigit(userInput.charAt(i))){
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.\n");
            }
        }
    }

    private void validateDivisibleByThousand(String userInput) {
        if ((Integer.parseInt(userInput) % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.\n");
        }
    }

    public List<Integer> getWinningNumbers() {
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
