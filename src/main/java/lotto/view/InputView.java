package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.controller.LottoController.winningLotto;

public class InputView {
    public static int inputMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .forEach(numbers::add);
        return numbers;
    }

    public static int inputBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());
        try {
            validateDuplicated(bonusNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            inputBonusNumber();
        }
        return bonusNumber;
    }

    private void validateMoney(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액입니다.");
        }
    }

    private static void validateDuplicated(int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 이미 뽑은 공입니다.");
        }
    }
}