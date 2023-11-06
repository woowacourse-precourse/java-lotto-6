package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Result;
import lotto.model.Ticket;
import lotto.model.WinningNum;
import lotto.model.Lotto;

public class LottoController {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LENGTH = 6;

    public static List<Lotto> generateTicket(int number) {
        List<Lotto> ticket = new ArrayList<Lotto>();
        for (int i = 0; i < number / 1000; i++) {
            ticket.add(new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LENGTH)));
        }
        return ticket;
    }

    public static List<Result> determine(Ticket ticket, WinningNum winningNum, int bonusNum) {
        List<Result> result = new ArrayList<Result>();
        for (Lotto lotto : ticket.getLottos()) {
            double countOfSameNum = searchSameNum(lotto.getNumbers(), winningNum.getNumbers(), bonusNum);
            Result lottoResult = Result.getResult(countOfSameNum);
            result.add(lottoResult);
        }
        return result;
    }

    private static double searchSameNum(List<Integer> numbers, List<Integer> winningNum, int bonusNum) {
        double count = 0;
        for (Integer number : numbers) {
            if (winningNum.contains(number)) {
                count++;
            }
        }
        if (count == 5 && isContainBonus(numbers, bonusNum)) {
            count += 0.5;
        }
        return count;
    }

    static boolean isContainBonus(List<Integer> numbers, int bonusNum) {
        boolean result = false;
        if (numbers.contains(bonusNum)) {
            result = true;
        }
        return result;
    }

    public static double calculateReturn(List<Result> result, int payment) {
        double returnMoney = 0;
        for (Result lottoResult : result) {
            returnMoney += lottoResult.getReturnMoney();
        }
        return ((returnMoney / payment) * 100.00);
    }
}
