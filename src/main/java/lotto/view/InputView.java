package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.LottoController;
import lotto.controller.Validator;

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
        String playerInput = "";

        while (true) {
            playerInput = readLine();

            if (Validator.isValidAnswerLottoNumbers(playerInput)) {
                break;
            }
        }
        return Arrays.stream(playerInput.split(Validator.DELEMTER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        String playerInput = "";

        while (true) {
            playerInput = readLine();

            if (Validator.isValidBonusNumber(LottoController.getAnswerlottoNumbers(), playerInput)) {
                break;
            }
        }
        return Integer.parseInt(playerInput);
    }
}
