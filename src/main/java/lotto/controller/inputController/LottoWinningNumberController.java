package lotto.controller.inputController;

import lotto.view.inputView.LottoWinningNumberInput;
import lotto.model.lottoResultChecker.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


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
            throw new IllegalArgumentException("[ERROR] 숫자 형식의 번호를 입력해야 합니다.");
        }
    }
}
