package lotto.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public int inputLottoCost() {
        int cost = inputInt("구입금액을 입력해 주세요.");
        while (!validateLottoCost(cost)) {
            cost = inputInt("구입금액을 입력해 주세요.");
        }
        return cost;
    }

    public int inputBonusNumber(List<Integer> numbers) {
        int number = inputInt("\n보너스 번호를 입력해 주세요.");
        while (!validateBonusNumber(numbers, number)) {
            number = inputInt("보너스 번호를 입력해 주세요.");
        }
        return number;
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = inputMultipleInt("\n당첨 번호를 입력해 주세요.");
        while (!validateWinningNumbers(winningNumbers)) {
            winningNumbers = inputMultipleInt("당첨 번호를 입력해 주세요.");
        }
        return winningNumbers;
    }

    // 숫자 입력 관련 함수
    private int inputInt(String message) {
        System.out.println(message);
        String input = Console.readLine();
        while (!validateInputInt(input)) {
            System.out.println(message);
            input = Console.readLine();
        }
        return Integer.parseInt(input);
    }

    private List<Integer> inputMultipleInt(String message) {
        System.out.println(message);
        String input = Console.readLine();
        return stringListToIntList(Arrays.asList(input.split(",")));
    }

    private List<Integer> stringListToIntList(List<String> strings) {
        List<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < strings.size(); i++) {
            integers.add(Integer.parseInt(strings.get(i)));
        }
        return integers;
    }

    private boolean validateInputInt(String input) {
        if (!isInteger(input)) {
            try {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    // 예외 처리
    private boolean validateLottoCost(int cost) {
        if (cost % 1000 != 0) {
            try {
                throw new IllegalArgumentException("[ERROR] 1000단위의 숫자가 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    private boolean validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        try {
            isNumberInRange(bonusNumber);
            duplicateCheckForBonusNumber(numbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean validateWinningNumbers(List<Integer> numbers) {
        try {
            isNumberInRangeForMultipleNumber(numbers);
            duplicateCheckForWinningNumbers(numbers);
            checkListSize(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private void checkListSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.");
        }
    }

    private void isNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1과 45사이의 숫자가 아닙니다.");
        }
    }

    private void isNumberInRangeForMultipleNumber(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            isNumberInRange(numbers.get(i));
        }
    }

    private void duplicateCheckForBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERRPR] 당첨 번호 중 중복되는 숫자가 있습니다.");
        }
    }

    private void duplicateCheckForWinningNumbers(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
        }
    }

}
