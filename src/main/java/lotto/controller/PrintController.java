package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Statistics;

import java.util.List;

import static lotto.enums.Message.*;
import static lotto.service.DrawStatistics.lottoStatistics;
import static lotto.service.IssueLotto.amountOfLottoTickets;
import static lotto.service.IssueLotto.lottoTickets;

public class PrintController {
    public static void printInputMoneyMsg() {
        System.out.println(INPUT_MONEY_MSG.getMessage());
    }
    public static void printNextLine() {
        System.out.println("");
    }
    public static void printAmountOfLottoTickets() {
        System.out.printf(AMOUNT_OF_LOTTO_TICKETS_MSG.getMessage(), amountOfLottoTickets);
    }
    public static void printLottoTickets() {
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers.toString());
        }
    }
    public static void printInputWinningNumbersMsg() {
        System.out.println(INPUT_WINNING_NUMBER_MSG.getMessage());
    }
    public static void printInputBonusNumberMsg() {
        System.out.println(INPUT_BONUS_NUMBER_MSG.getMessage());
    }
    public static void printStatistics() {
        System.out.println(STATISTICS_INFORM.getMessage());
        System.out.println(DISTINGUISH.getMessage());
        for(Statistics statistics : lottoStatistics) {
            System.out.printf(PRINT_STATISTICS.getMessage(), statistics.getValue(), statistics.getAmountOfTickets());
        }
    }
    public static void printEarningRate(double earningRate) {
        System.out.printf(PRINT_EARNING_RATE.getMessage(), earningRate);
    }
}
