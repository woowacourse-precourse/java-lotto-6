package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.controller.Exception;
import lotto.controller.Validator;
import java.util.List;

public class InputView {
    public static int getBuyAmount() {
        String playerInput = readLine();

        if (Validator.isBuyAmountValid(playerInput)) {
            return Integer.parseInt(playerInput);
        }

        return -1;
    }

    public static List<Integer> getAnswerLottoNumbers() {
        String playerInput = readLine();

        if (Validator.isValidAnswerLottoNumbers(playerInput)) {
            return Arrays.stream(playerInput.split(Validator.DELEMTER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }

        return null;
    }
}
