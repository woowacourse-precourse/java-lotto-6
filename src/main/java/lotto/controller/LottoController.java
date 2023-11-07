package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.service.IssueLotto;
import lotto.service.DrawStatistics;

import java.util.List;

import static lotto.service.DrawStatistics.earningRate;
import static lotto.service.DrawStatistics.lottoStatistics;

public class LottoController {
    public static void run() {
        /*
        PrintController.printInputMoneyMsg();
        InputController inputController = new InputController();
        inputController.inputMoney();
        PrintController.printNextLine();
        int amountOfLottoTickets = IssueLotto.getAmountOfLottoTickets();
        PrintController.printAmountOfLottoTickets(amountOfLottoTickets);
        List<Lotto> lottoTickets = IssueLotto.makeLottoTickets();
        PrintController.printLottoTickets(lottoTickets);
        PrintController.printNextLine();
        PrintController.printInputWinningNumbersMsg();
        inputController.inputWinningNumbers();
        PrintController.printNextLine();
        PrintController.printInputBonusNumberMsg();
        inputController.inputBonusNumber();
        PrintController.printNextLine();
         */

        // List<Statistics> lottoStatistics = DrawStatistics.makeStatistics(DrawStatistics.countCorrectNumbers());
        // PrintController.printStatistics(lottoStatistics);
        // double earningRate = DrawStatistics.getEarningRate(lottoStatistics);
        // PrintController.printEarningRate(earningRate);
        LottoController.runInputMoney();
        LottoController.runIssueLotto();
        LottoController.runInputNumber();
        LottoController.runDrawStatistics();
        LottoController.runPrintEarningRate();
    }
    public static void runInputMoney() {
        PrintController.printInputMoneyMsg();
        InputController.inputMoney();
        PrintController.printNextLine();
    }
    public static void runIssueLotto() {
        IssueLotto.getAmountOfLottoTickets();
        PrintController.printAmountOfLottoTickets();
        IssueLotto.makeLottoTickets();
        PrintController.printLottoTickets();
        PrintController.printNextLine();
    }
    public static void runInputNumber() {
        PrintController.printInputWinningNumbersMsg();
        InputController.inputWinningNumbers();
        PrintController.printNextLine();
        PrintController.printInputBonusNumberMsg();
        InputController.inputBonusNumber();
        PrintController.printNextLine();
    }
    public static void runDrawStatistics() {
        DrawStatistics.countCorrectNumbers();
        DrawStatistics.makeStatistics();
        PrintController.printStatistics();
        DrawStatistics.getEarningRate();
    }
    public static void runPrintEarningRate() {
        PrintController.printEarningRate(earningRate);
    }
}