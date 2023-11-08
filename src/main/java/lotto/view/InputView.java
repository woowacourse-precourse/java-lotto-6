package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.controller.Exception;
import lotto.controller.LottoController;
import lotto.controller.Validator;
import java.util.List;

public class InputView {
    public static int getBuyAmount() {
        String playerInput = "";

        while (true) {
            playerInput = readLine();
            if (Validator.isBuyAmountValid(playerInput)) {
                break;
            }
        }
        return Integer.parseInt(playerInput);
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

    public static int getBonusNumber() {
        String playerInput = readLine();

        if (Validator.isValidBonusNumber(LottoController.getAnswerlottoNumbers(), playerInput)) {
            return Integer.parseInt(playerInput);
        }

        return -1;
    }
}
