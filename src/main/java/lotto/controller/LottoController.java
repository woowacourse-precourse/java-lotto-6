package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.WinningRank;
import lotto.service.LottoService;
import lotto.utils.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void start() {
        int lottoPayAmount = inputLottoPayAmount();
        publishLottosByPayAmount(lottoPayAmount);

        List<Integer> jackpotNumbers = inputJackpotNumberInput();
        int bonusNumberInput = inputBonusNumberInput(jackpotNumbers);

        HashMap<WinningRank, Integer> winningStatistics = getWinningStatistics(jackpotNumbers, bonusNumberInput);
        long returnAmount = lottoService.calculateReturnAmount(winningStatistics);
        announceRateOfReturn(lottoPayAmount, returnAmount);
    }

    public static int inputLottoPayAmount() {
        String lottoPayAmount;
        while (true) {
            try {
                InputView.printPayAmountInputMessage();
                lottoPayAmount = Console.readLine();
                InputValidator.checkLottoPayAmountInput(lottoPayAmount);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return Integer.parseInt(lottoPayAmount);
    }

    public void publishLottosByPayAmount(int lottoPayAmount) {
        List<Lotto> lottos = lottoService.publishLottos(lottoPayAmount);
        OutputView.printPaySuccessMessageMessage(lottos.size());
        OutputView.printLottos(lottos);
    }

    public static List<Integer> inputJackpotNumberInput() {
        String jackpotNumberInput;
        while (true) {
            try {
                InputView.printJackpotNumberInputMessage();
                jackpotNumberInput = Console.readLine();
                InputValidator.checkJackpotNumberInput(jackpotNumberInput);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return converteToList(jackpotNumberInput);
    }

    private static List<Integer> converteToList(String jackpotNumberInput) {
        List<Integer> jackpotNumbers = new ArrayList<>();
        for (String number : jackpotNumberInput.split(",")) {
            jackpotNumbers.add(Integer.parseInt(number));
        }
        return jackpotNumbers;
    }

    public static int inputBonusNumberInput(List<Integer> jackpotNumbers) {
        String bonusNumberInput;
        while (true) {
            try {
                InputView.printBonusNumberInputMessage();
                bonusNumberInput = Console.readLine();
                InputValidator.checkBonusNumberInput(bonusNumberInput);
                InputValidator.checkDuplicateNumberInBonusNumbers(jackpotNumbers, bonusNumberInput);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return Integer.parseInt(bonusNumberInput);
    }

    public HashMap<WinningRank, Integer> getWinningStatistics(List<Integer> jackpotNumbers, int bonusNumberInput) {
        OutputView.printWinningStatisticsMessage();
        HashMap<WinningRank, Integer> winningStatistics = lottoService.getWinningStatistics(jackpotNumbers,
                bonusNumberInput);
        OutputView.printWinningStatistics(winningStatistics);

        return winningStatistics;
    }

    public void announceRateOfReturn(int lottoPayAmount, long returnAmount) {
        double rateOfReturn = lottoService.getRateOfReturn(lottoPayAmount, returnAmount);
        OutputView.printRateOfReturn(rateOfReturn);
    }
}
