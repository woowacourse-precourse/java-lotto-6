package lotto.controller;

import lotto.domain.Player;
import lotto.dto.response.LottiesInfoDto;
import lotto.domain.LottoShop;
import lotto.validation.InputValidator;
import lotto.view.ConsoleOutput;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final LottoShop lottoShop;
    private final OutputView outputView;

    public LottoController(InputView inputView, LottoShop lottoShop, OutputView outputView) {
        this.inputView = inputView;
        this.lottoShop = lottoShop;
        this.outputView = outputView;
    }

    public void run() {
        String input = getUserInput();
        setPlayerVariableValue(input);
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

    private void setPlayerVariableValue(String input) {
        Player player = new Player(input, lottoShop);
        LottiesInfoDto lottiesInfoDto = player.buyLotties();
        printLottiesNumberAndTicket(lottiesInfoDto);
    }

    private void printLottiesNumberAndTicket(LottiesInfoDto lottiesInfoDto) {
        ConsoleOutput.printNewLine();
        outputView.displayticket(lottiesInfoDto.ticket());
        outputView.displayLottiesNumber(lottiesInfoDto.lottiesNumber());
    }
}
