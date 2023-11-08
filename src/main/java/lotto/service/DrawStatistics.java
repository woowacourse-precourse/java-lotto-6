package lotto.service;

import lotto.Enum.Constant;
import lotto.Enum.Rank;
import lotto.model.Lotto;
import lotto.model.Statistics;

import java.util.*;

import static lotto.Enum.Constant.*;
import static lotto.controller.InputController.*;
import static lotto.service.IssueLotto.lottoTickets;

public class DrawStatistics {
    public static List<Integer> amountOfCorrectNumbers;
    public static List<Statistics> lottoStatistics;
    public static double earningRate;
    public static int compareWithWinningNumbers(Lotto lottoTicket) {
        List<Integer> lottoNumbers = lottoTicket.getNumbers();
        Set<Integer> findCorrectNumbers = new HashSet<>(lottoNumbers);
        int countingCorrectNumbers = NUMBER_FOR_INITIALIZATION.getValue();

        for (Integer num : winningNumbers) {
            if(findCorrectNumbers.contains(num)) {
                countingCorrectNumbers++;
            }
        }
        if (countingCorrectNumbers == AMOUNT_OF_CORRECT_NUMBER.getValue()) {
            countingCorrectNumbers = compareWithBonusNumber(lottoNumbers);
        }
        return countingCorrectNumbers;
    }
    public static int compareWithBonusNumber(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            if (number == bonusNumber) {
                return CORRECT_WITH_BONUS_NUMBER.getValue();
            }
        }
        return AMOUNT_OF_CORRECT_NUMBER.getValue();
    }
    public static void countCorrectNumbers() {
        amountOfCorrectNumbers = new ArrayList<>();
        for (Lotto lottoTicket : lottoTickets) {
            amountOfCorrectNumbers.add(compareWithWinningNumbers(lottoTicket));
        }
    }
    public static int countCorrespondingTickets(Rank rank, List<Integer> amountOfCorrectNumbers) {
        int counter = NUMBER_FOR_INITIALIZATION.getValue();
        for (Integer correctNumbers : amountOfCorrectNumbers) {
            if (correctNumbers == rank.getCorrectNumbers()) {
                counter ++;
            }
        }
        return counter;
    }
    public static void makeStatistics() {
        lottoStatistics = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            lottoStatistics.add(new Statistics(
                    rank.getDescription(),
                    rank.getPrizeAmount(),
                    countCorrespondingTickets(rank, amountOfCorrectNumbers)
            ));
        }
    }
    public static void getEarningRate() {
        earningRate = NUMBER_FOR_INITIALIZATION.getValue();
        for (Statistics statistics : lottoStatistics) {
            earningRate += statistics.getValueNumber()*statistics.getAmountOfTickets();
        }
        earningRate = earningRate / money * PERCENT.getValue();
    }
}
