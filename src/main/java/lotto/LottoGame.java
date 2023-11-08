package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {
    public static void play() {
        Long budget = getBudget();
        List<Lotto> tickets = LottoGameUtils.issueLotto(budget);
        UserInteraction.printTickets(tickets);
        List<Integer> winningNumbers = getWinningNumbers();
        LottoWinning lottoWinning = LottoGameUtils.createLottoWinningWithNumbers(winningNumbers);
        Integer bonusNumber = getBonusNumber();
        LottoGameUtils.updateLottoWinningWithBonus(lottoWinning, bonusNumber);
        Map<LottoRank, Integer> winningCount =  LottoGameUtils.evaluateLottoWinning(lottoWinning, tickets);
        double rateOfReturn = LottoGameUtils.calculateRateOfReturn(budget, winningCount);
        UserInteraction.printWinningStatistic(winningCount);
        UserInteraction.printRateOfReturn(rateOfReturn);
    }

    private static Long getBudget() {
        while (true) {
            try {
                String budget = UserInteraction.promptBudget();
                return parsePositiveInteger(budget);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String[] numbers = UserInteraction.promptWinningNumbers().split(",");
                return parsePositiveIntegers(numbers);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
            }
        }
    }

    private static Integer getBonusNumber() {
        while (true) {
            try {
                String number = UserInteraction.promptBonusNumber();
                return parsePositiveInteger(number).intValue();
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
            }
        }
    }

    private static Long parsePositiveInteger(String integer) {
        try {
            int number = Integer.parseInt(integer);
            if (number <= 0) {
                throw new IllegalArgumentException("[ERROR] 음수입니다.");
            }
            return Long.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

    private static List<Integer> parsePositiveIntegers(String[] integers) {
        List<Integer> parsedIntegers = new ArrayList<>();
        for(String integer: integers) {
            parsedIntegers.add(parsePositiveInteger(integer).intValue());
        }
        return parsedIntegers;
    }
}


