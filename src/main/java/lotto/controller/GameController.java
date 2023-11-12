package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.OutputMessage;
import lotto.constant.WinningValues;
import lotto.model.LottoDatas;
import lotto.service.CalculationLogic;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private final LottoService lottoService;
    private final LottoDatas lottoDatas;
    private final CalculationLogic calculationLogic;


    public GameController() {
        this.lottoDatas = new LottoDatas();
        this.lottoService = new LottoService(lottoDatas);
        this.calculationLogic = new CalculationLogic(lottoDatas);
    }

    public void run() {
        inputPurchase();
        lottoDatas.generateLottoNumbers();
        printLotto();
        inputWinningNumbers();
        inputBonusNumber();
        printFinalPrize();
    }

    private void inputPurchase() {
        while (true) {
            String inputPurchase = InputView.inputPurchase();
            try {
                lottoService.convertPurchaseToCount(inputPurchase);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printLotto() {
        lottoService.printLottoCount();
        lottoService.printLottoNumbers();
    }

    private void inputWinningNumbers() {
        while (true) {
            String inputLottoNumbers = InputView.inputWinningNumbers();
            try {
                lottoService.convertToIntegerList(inputLottoNumbers);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void inputBonusNumber() {
        while (true) {
            String inputBonusNumbers = InputView.inputBonusNumber();
            try {
                lottoService.checkBonusNumber(inputBonusNumbers);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printFinalPrize() {
        OutputView.printFinalOutput();
        calculationLogic.calculateFinalPrize();
        double profit = calculationLogic.importProfitValue();
        Map<Integer, Integer> WinningCounts = initialSetting();
        WinningCounts = calculationLogic.getAllLottoCounts(WinningCounts);
        List<Integer> convertCount = new ArrayList<>();
        convertCount = ConvertCount(WinningCounts);

        checkFinalResults(convertCount, profit);
    }

    private Map<Integer, Integer> initialSetting() {
        Map<Integer, Integer> initMap = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            initMap.put(i, 0);
        }
        return initMap;
    }

    private List<Integer> ConvertCount(Map<Integer, Integer> WinningCounts) {
        List<Integer> convertCount = new ArrayList<>();
        for (int mapIndex = WinningValues.OUTPUT_LOTTO_5TH_PLACE.getWinningCount();
             mapIndex <= WinningValues.OUTPUT_LOTTO_1ST_PLACE.getWinningCount(); mapIndex++) {
            if (mapIndex == WinningValues.OUTPUT_LOTTO_1ST_PLACE.getWinningCount()) {
                convertCount.add(checkNull(WinningCounts.get(2)));
            }
            convertCount.add(checkNull(WinningCounts.get(mapIndex)));
        }
        return convertCount;
    }

    private int checkNull(int winningCount) {
        if (winningCount == 0) {
            return 0;
        }
        return winningCount;
    }

    private void checkFinalResults(List<Integer> WinningCounts, double profit) {
        int index = -1;
        for (WinningValues winningValues : WinningValues.values()) {
            if (winningValues.getMessage().equals("NOTHING")) {
                index++;
                continue;
            }
            int hitCount = checkHitCount(WinningCounts.get(index));

            OutputView.printFinalResults(winningValues.getMessage(), hitCount);
            index++;
        }
        OutputView.printFinalProfit(OutputMessage.FINAL_OUTPUT.getMessage(), profit);
    }

    private int checkHitCount(int winningCount) {
        if (winningCount == 0) {
            return 0;
        }
        return winningCount;

    }


}
