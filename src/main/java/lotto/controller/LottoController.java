package lotto.controller;

import java.util.List;
import lotto.domain.Player;
import lotto.dto.response.LottiesInfoDto;
import lotto.domain.LottoShop;
import lotto.service.LottoService;
import lotto.validation.InputValidator;
import lotto.view.ConsoleOutput;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final LottoShop lottoShop;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, LottoShop lottoShop, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.lottoShop = lottoShop;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        String input = getUserInput();
        Player player = setPlayerVariableValue(input);
        List<Integer> winningNumbers = getwinningNumbers();
    }

    private String getUserInput() {
        String input;
        while (true) {
            ConsoleOutput.displayUserInputPrompt();
            input = inputView.getUserPurchaseAmount();
            if (isValidInput(input)) {
                break;
            }
        }
        return input;
    }

    private boolean isValidInput(String input) {
        try {
            InputValidator.validateUserInput(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private Player setPlayerVariableValue(String input) {
        Player player = new Player(input, lottoShop);
        LottiesInfoDto lottiesInfoDto = player.buyLotties();
        printLottiesNumberAndTicket(lottiesInfoDto);
        return player;
    }

    private void printLottiesNumberAndTicket(LottiesInfoDto lottiesInfoDto) {
        ConsoleOutput.printNewLine();
        outputView.displayticket(lottiesInfoDto.ticket());
        outputView.displayLottiesNumber(lottiesInfoDto.lottiesNumber());
    }

    private List<Integer> getwinningNumbers() {
        ConsoleOutput.displayWinningNumberPrompt();
        String winningNumber = inputView.getWinningNumber();
        List<Integer> validateWinningNumber = validateWinningNumber(winningNumber);
        return validateWinningNumber;
    }

    private List<Integer> validateWinningNumber(String winningNumber) {
        return lottoService.convertStringToList(winningNumber);
    }
}
