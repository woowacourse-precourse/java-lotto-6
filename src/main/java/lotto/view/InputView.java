package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.controller.LottoController.winningLotto;

public class InputView {
    public static int inputMoney() {
        return validateInteger(Console.readLine());
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
            LottoNumber.validateNumberRange(bonusNumber);
            LottoNumber.validateDuplicated(winningLotto.getNumbers(), bonusNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            inputBonusNumber();
        }
        return bonusNumber;
    }

    public static int validateInteger(String input) {
        while (true) {
            try {
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 정수를 입력해주세요.");
                input = Console.readLine();
            }
        }
    }
}