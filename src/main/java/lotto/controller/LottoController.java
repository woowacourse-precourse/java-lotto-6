package lotto.controller;

import java.util.List;
import lotto.domain.Bank;
import lotto.domain.Player;
import lotto.dto.response.LottosInfoDto;
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
    private Bank bank;

    public LottoController(InputView inputView, LottoShop lottoShop, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.lottoShop = lottoShop;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        String input = getUserInput();
        createLottos(input);
        List<Integer> winningNumbers = getWinningNumbers();
        getExtraWinningNumber(winningNumbers);
        calculateWinningStatistics();
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

    private void createLottos(String input) {
        Player player = new Player(input, lottoShop);
        LottosInfoDto lottosInfoDto = player.buyLottos();
        printLottosNumberAndTicket(lottosInfoDto);
    }

    private void printLottosNumberAndTicket(LottosInfoDto lottosInfoDto) {
        ConsoleOutput.printNewLine();
        outputView.displayticket(lottosInfoDto.ticket());
        outputView.displayLottosNumber(lottosInfoDto.lottosNumbers());
    }

    private List<Integer> getWinningNumbers() {
        bank = new Bank();
        String input = getWinningNumberInput();
        List<Integer> winningNumbers = convertStringToWinningNumbers(input);
        setWinningNumbersInBank(winningNumbers);
        return winningNumbers;
    }

    private String getWinningNumberInput() {
        String input;
        while (true) {
            ConsoleOutput.printNewLine();
            ConsoleOutput.displayWinningNumberPrompt();
            input = inputView.getWinningNumber();
            if (validateWinningNumber(input)) {
                break;
            }
        }
        return input;
    }

    private List<Integer> convertStringToWinningNumbers(String input) {
        return lottoService.convertStringToList(input);
    }

    private void setWinningNumbersInBank(List<Integer> winningNumbers) {
        bank.setWinningNumbers(winningNumbers);
    }

    private boolean validateWinningNumber(String input) {
        try {
            List<Integer> winningNumbers = lottoService.convertStringToList(input);
            InputValidator.validateWinningNumber(winningNumbers);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void getExtraWinningNumber(List<Integer> winningNumbers) {
        String input = getExtraWinningNumberInput(winningNumbers);
        setExtraWinningNumberInBank(input);
    }

    private String getExtraWinningNumberInput(List<Integer> winningNumbers) {
        String input;
        while (true) {
            ConsoleOutput.printNewLine();
            ConsoleOutput.displayExtraWinningNumberPrompt();
            input = inputView.getExtraWinningNumber();
            if (validateExtraWinningNumber(input, winningNumbers)) {
                break;
            }
        }
        return input;
    }

    private void setExtraWinningNumberInBank(String input) {
        bank.setExtraWinningNumber(Integer.parseInt(input));
    }

    private boolean validateExtraWinningNumber(String input, List<Integer> winningNumbers) {
        try {
            InputValidator.validateExtraWinningNumber(input, winningNumbers);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void calculateWinningStatistics() {
        ConsoleOutput.printNewLine();
        ConsoleOutput.displayWinningStatistics();
    }
}
