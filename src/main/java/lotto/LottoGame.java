package lotto;

import lotto.controller.InputController;
import lotto.controller.MainController;
import lotto.controller.OutputController;
import lotto.dto.ConsumerDto;
import lotto.dto.WinningLottoDto;

public class LottoGame {

    InputController inputController;
    OutputController outputController;
    MainController mainController;

    public LottoGame() {
        this.inputController = new InputController();
        this.outputController = new OutputController();
        this.mainController = new MainController();
    }

    public void run() {
        ConsumerDto consumerDto = new ConsumerDto();
        WinningLottoDto winningLottoDto = new WinningLottoDto();

        settingGame(consumerDto, winningLottoDto);
        calculateThisGame(consumerDto, winningLottoDto);
        printResult(consumerDto);
    }

    private void settingGame(ConsumerDto consumerDto, WinningLottoDto winningLottoDto) {
        inputController.settingPurchaseAmount(consumerDto);
        outputController.orderPrintTicketQuantity(consumerDto);

        mainController.settingConsumerLottos(consumerDto);
        outputController.orderPrintConsumerLottos(consumerDto);

        inputController.settingWinningNumbers(winningLottoDto);
    }

    private void calculateThisGame(ConsumerDto consumerDto, WinningLottoDto winningLottoDto) {
        mainController.setRankingResult(consumerDto, winningLottoDto);
        mainController.setReturnOfRate(consumerDto);
    }

    private void printResult(ConsumerDto consumerDto) {
        outputController.orderPrintResult(consumerDto);
    }

}
