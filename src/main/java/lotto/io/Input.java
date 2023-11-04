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
        validateAboveOrEqualThousand(userInput);
        validateDivisibleByThousand(userInput);
    }

    private void validateOnlyNumbers(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if(!Character.isDigit(userInput.charAt(i))){
                throw new IllegalArgumentException("[ERROR] 1000원 이상 숫자만 입력해 주세요.\n");
            }
        }
    }

    private void validateAboveOrEqualThousand(String userInput) {
        if (Integer.parseInt(userInput) < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상 입력해 주세요.\n");
        }
    }

    private void validateDivisibleByThousand(String userInput) {
        if ((Integer.parseInt(userInput) % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.\n");
        }
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> userInput = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateWinningNumbers(userInput);
        return userInput;
    }

    private void validateWinningNumbers(List<Integer> userInput) {
        validateNumbersSizeSix(userInput);
    }

    private void validateNumbersSizeSix(List<Integer> userInput) {
        if (userInput.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리 숫자를 입력해 주세요.");
        }
    }

    public int getBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
