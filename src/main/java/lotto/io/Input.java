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
        validateOnlyNumber(userInput);
        validateAboveOrEqualThousand(userInput);
        validateDivisibleByThousand(userInput);
    }

    private void validateOnlyNumber(String userInput) {
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
        List<String> userInput = Arrays.asList(Console.readLine().split(","));
        validateWinningNumbers(userInput);

        return userInput.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateWinningNumbers(List<String> userInput) {
        validateNoBlank(userInput);
        validateOnlyNumbers(userInput);
        validateNumbersSizeSix(userInput);
        validateNumberRange(userInput);
        validateDuplicatedNumber(userInput);
    }

    private void validateNoBlank(List<String> userInput) {
        if (userInput.stream().anyMatch(num -> num.contains(" "))) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력이 불가능 합니다.");
        }
    }

    private void validateOnlyNumbers(List<String> userInput) {
        for (String num : userInput) {
            if(!(num.chars().allMatch(Character::isDigit))) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
            }
        }
    }

    private void validateNumbersSizeSix(List<String> userInput) {
        if (userInput.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리 숫자를 입력해 주세요.");
        }
    }

    private void validateNumberRange(List<String> userInput) {
        if (userInput.stream()
                .mapToInt(Integer::parseInt)
                .anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 각 번호는 1 이상 45 이하로 입력해 주세요.");
        }
    }

    private void validateDuplicatedNumber(List<String> userInput) {
        if (userInput.size() != userInput.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 6자리 숫자를 입력해 주세요.");
        }
    }

    public int getBonusNumber() {
        String userInput = Console.readLine();
        validateBonusNumber(userInput);
        return Integer.parseInt(userInput);
    }

    private void validateBonusNumber(String userInput) {
        validateOnlyOneNumber(userInput);
        validateBonusNumberRange(userInput);
    }

    private void validateOnlyOneNumber(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if(!Character.isDigit(userInput.charAt(i))){
                throw new IllegalArgumentException("[ERROR] 0 이상 숫자 하나만 입력해 주세요.");
            }
        }
    }

    private void validateBonusNumberRange(String userInput) {
        int bonusNumber = Integer.parseInt(userInput);
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 이상 45 이하로 입력해 주세요.");
        }
    }
}
