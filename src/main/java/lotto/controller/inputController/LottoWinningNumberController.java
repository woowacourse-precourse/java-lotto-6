package lotto.controller.inputController;

import lotto.view.inputView.LottoWinningNumberInput;
import lotto.model.lottoResultChecker.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.ErrorMessages.ONLY_NUMBERS_ALLOWED;


public class LottoWinningNumberController {
    private final LottoWinningNumberInput winningNumberInput;

    public LottoWinningNumberController() {
        this.winningNumberInput = new LottoWinningNumberInput();
    }

    public Lotto receiveAndCreateLotto() {
        while (true) {
            try {
                String input = winningNumberInput.requestWinningNumbers();
                List<Integer> numbers = parseWinningNumbers(input);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private List<Integer> parseWinningNumbers(String input) {
        try {
            return Arrays.stream(input.split(",\\s*"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBERS_ALLOWED);
        }
    }
}
