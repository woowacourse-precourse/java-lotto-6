package lotto.service;

import lotto.domain.WinningLottoTicket;
import lotto.exception.WinningNumberValidationException;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoService {
    public List<Integer> getWinningNumbers() {
        InputView.promptWinningNumbers();

        while (true) {
            try {
                String winningNumberView = InputView.readWinningNumbers();
                return parseAndValidateWinningNumbers(winningNumberView);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseAndValidateWinningNumbers(String winningNumberView) {
        validateLottoNumberFormat(winningNumberView);

        List<Integer> winningNumbers = convertInputToNumbers(winningNumberView);
        validateWinningNumber(winningNumbers);

        return winningNumbers;
    }

    private void validateLottoNumberFormat(String input) {
        WinningNumberValidationException.checkLottoNumberFormat(input);
    }

    private void validateWinningNumber(List<Integer> winningNumbers) {
        WinningNumberValidationException.checkWinningNumberLength(winningNumbers);
        WinningNumberValidationException.checkDuplicateWinningNumbers(winningNumbers);
        WinningNumberValidationException.checkBoundaryOfWinningNumbers(winningNumbers);
    }

    public WinningLottoTicket createWinningLottoTicket(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLottoTicket(winningNumbers, bonusNumber);
    }

    private List<Integer> convertInputToNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
