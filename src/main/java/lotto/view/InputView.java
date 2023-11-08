package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoNumber;

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
            LottoNumber.validateNumberRange(bonusNumber);
            LottoNumber.validateDuplicated(winningLotto.getNumbers(), bonusNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            inputBonusNumber();
        }
        return bonusNumber;
    }
}