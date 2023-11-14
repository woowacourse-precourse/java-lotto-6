package lotto.presentation.controller;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoWinningNumbers;
import lotto.presentation.view.View;
import lotto.repository.LottoTicketRepository;
import lotto.service.Referee;

public class WinningNumberController {
    private View view;
    private Referee referee;
    private LottoTicketRepository ticketRepository;

    public WinningNumberController(View view, Referee referee, LottoTicketRepository ticketRepository) {
        this.view = view;
        this.referee = referee;
        this.ticketRepository = ticketRepository;
    }

    public LottoWinningNumbers lottoWinningNumbersGenerationLogic() {
        while (true) {
            try {
                Lotto winningLotto = readAndGenerateWinningNumber();
                int BonusNumber = readAndGenerateBonusNumber();
                return new LottoWinningNumbers(winningLotto.getNumbers(), BonusNumber);
            } catch (IllegalArgumentException e) {
                view.promptForError(e);
            }
        }
    }

    private Lotto readAndGenerateWinningNumber() {
        while (true) {
            view.promptForWinningNumber();
            List<String> inputWinningNumbers = Arrays.asList(LottoGameController.readAndRemoveSpace().split(","));
            try {
                getValidWinningNumber(inputWinningNumbers);
                List<Integer> winningNumbers = parseWinningNumbers(inputWinningNumbers);
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                view.promptForError(e);
            }
        }
    }

    private void getValidWinningNumber(List<String> inputWinningNumbers) {
        inputWinningNumbers.forEach(inputNumber -> {
            LottoGameController.isNotBlankValue(inputNumber);
            LottoGameController.isNotIntegerValue(inputNumber);
        });
    }

    private List<Integer> parseWinningNumbers(List<String> inputWinningNumbers) {
        return inputWinningNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private int readAndGenerateBonusNumber() {
        while (true) {
            view.promptForBonusNumber();
            String inputBonusNumber = LottoGameController.readAndRemoveSpace();
            try {
                getValidBonusNumber(inputBonusNumber);
                return Integer.parseInt(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                view.promptForError(e);
            }
        }
    }

    private void getValidBonusNumber(String inputBonusNumber) {
        LottoGameController.isNotBlankValue(inputBonusNumber);
        LottoGameController.isNotIntegerValue(inputBonusNumber);
    }
}
