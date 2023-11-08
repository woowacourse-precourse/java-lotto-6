package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.service.IssueLotto;
import lotto.service.DrawStatistics;

import java.util.List;

import static lotto.service.DrawStatistics.earningRate;

public class LottoController {
    public static void run() {
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