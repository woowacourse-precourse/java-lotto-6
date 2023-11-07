package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.LottoValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public int readPurchaseAmount(LottoValidation lottoValidation) {
        String userInput = Console.readLine();
        lottoValidation.validatePurchaseAmount(userInput);
        return Integer.parseInt(userInput);
    }

    public List<Integer> readWinningNumber(LottoValidation lottoValidation) {
        String userInput = Console.readLine();
        lottoValidation.validateWinningNumber(userInput);
        List<Integer> winningNumber = new ArrayList<>();
        List<String> numbers = Arrays.asList(userInput.split(","));
        for (String number : numbers) {
            winningNumber.add(Integer.parseInt(number));
        }
        return winningNumber;
    }

    public int readBonusNumber(LottoValidation lottoValidation, List<Integer> winningNumber) {
        String userInput = Console.readLine();
        lottoValidation.validateBonusNumber(userInput, winningNumber);
        return Integer.parseInt(userInput);
    }
}
