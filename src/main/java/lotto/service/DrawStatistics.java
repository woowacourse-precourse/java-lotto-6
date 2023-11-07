package lotto.service;

import lotto.model.Lotto;
import lotto.model.Statistics;

import java.util.*;

import static lotto.controller.InputController.*;
import static lotto.service.IssueLotto.lottoTickets;

public class DrawStatistics {
    public static List<Integer> amountOfCorrectNumbers;
    public static List<Statistics> lottoStatistics;
    public static double earningRate;
    public static int compareWithWinningNumbers(Lotto lottoTicket) {
        List<Integer> lottoNumbers = lottoTicket.getNumbers();
        Set<Integer> findCorrectNumbers = new HashSet<>(lottoNumbers);
        int countingCorrectNumbers = 0;

        for (Integer num : winningNumbers) {
            if(findCorrectNumbers.contains(num)) {
                countingCorrectNumbers++;
            }
        }
        if (countingCorrectNumbers == 5) {
            countingCorrectNumbers = compareWithBonusNumber(lottoNumbers);
        }
        return countingCorrectNumbers;
    }
    public static int compareWithBonusNumber(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            if (number == bonusNumber) {
                return 7;
            }
        }
        return 5;
    }
    public static void countCorrectNumbers() {
        amountOfCorrectNumbers = new ArrayList<>();
        for (Lotto lottoTicket : lottoTickets) {
            amountOfCorrectNumbers.add(compareWithWinningNumbers(lottoTicket));
        }
    }
    public static int countCorrespondingTickets(int number,List<Integer> amountOfCorrectNumbers) {
        int counter = 0;
        for (Integer correctNumbers : amountOfCorrectNumbers) {
            if (correctNumbers == number) {
                counter ++;
            }
        }
        return counter;
    }
    public static void makeStatistics() {
        lottoStatistics = new ArrayList<>();
        lottoStatistics.add(new Statistics("3개 일치 (5,000원)",5000, countCorrespondingTickets(3, amountOfCorrectNumbers)));
        lottoStatistics.add(new Statistics("4개 일치 (50,000원)",50000, countCorrespondingTickets(4, amountOfCorrectNumbers)));
        lottoStatistics.add(new Statistics("5개 일치 (1,500,000원)",1500000, countCorrespondingTickets(5, amountOfCorrectNumbers)));
        lottoStatistics.add(new Statistics("5개 일치, 보너스 볼 일치 (30,000,000원)",30000000, countCorrespondingTickets(7, amountOfCorrectNumbers)));
        lottoStatistics.add(new Statistics("6개 일치 (2,000,000,000원)",2000000000, countCorrespondingTickets(6, amountOfCorrectNumbers)));
    }
    public static void getEarningRate() {
        earningRate = 0;
        for (Statistics statistics : lottoStatistics) {
            earningRate += statistics.getValueNumber()*statistics.getAmountOfTickets();
        }
        earningRate = earningRate / money * 100;
    }
}
