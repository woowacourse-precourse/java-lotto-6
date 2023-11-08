package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Bank;
import lotto.domain.Player;
import lotto.domain.enums.Prize;
import lotto.dto.response.LottoResultDto;
import lotto.dto.response.LottosInfoDto;
import lotto.service.LottoService;
import lotto.validation.InputValidator;
import lotto.view.ConsoleOutput;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private Bank bank;
    private Player player;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
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
        player = new Player(input);
        printLottosNumberAndTicket(player.buyLottos());
    }

    private void printLottosNumberAndTicket(LottosInfoDto lottosInfoDto) {
        ConsoleOutput.printNewLine();
        outputView.displayTicket(lottosInfoDto.ticket());
        outputView.displayLottosNumber(lottosInfoDto);
    }

    private List<Integer> getWinningNumbers() {
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
        this.bank = new Bank();
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
        Map<Prize, Integer> prizeCountMap = bank.calculatePrizeCountMap(player);
        int totalPrizeMoney = bank.calculateTotalPrizeMoney(prizeCountMap);
        double earningRate = bank.calculateEarningRate(totalPrizeMoney, player);

        LottoResultDto lottoResultDto = new LottoResultDto(prizeCountMap, earningRate);
        outputView.displayWinningStatistics(lottoResultDto);
        outputView.displayEarningRate(lottoResultDto);
    }
}
