package lotto.view;

import lotto.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int getPurchasingPrice() {
        String input = readLine();
        Validator.validateIsInt(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> getWinningLottoNumbers() {
        String input = readLine();
        List<String> numbers = Arrays.asList(input.split(","));
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number: numbers) {
            Validator.validateIsInt(number);
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    public static int getBonusNumber() {
        String input = readLine();
        Validator.validateIsInt(input);
        return Integer.parseInt(input);
    }
}
