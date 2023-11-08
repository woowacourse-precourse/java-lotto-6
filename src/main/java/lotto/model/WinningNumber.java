package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningNumber {
    private static final String INVALID_WINNING_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호가 유효하지 않습니다.";
    private List<Lotto> lottos = new ArrayList<>();

    public WinningNumber(String winningNumbers) {
        List<Integer> winningNumber = Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(this::parseWinningNumber)
                .toList();
        lottos.add(new Lotto(winningNumber));
    }

    private int parseWinningNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage(INVALID_WINNING_NUMBER_ERROR_MESSAGE);
            return parseWinningNumber(InputView.getWinningNumber());
        }
    }


}
