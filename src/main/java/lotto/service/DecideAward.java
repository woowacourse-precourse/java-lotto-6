package lotto.service;

import lotto.domain.JackpotNumber;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.Rank;

public class DecideAward {
    public static Result userResult(Lotto lotto, int bonus, JackpotNumber jackpotNumber) {
        Result result = new Result();
        result.add(Rank.valueOf(countMatch(lotto, jackpotNumber), matchBonusNumber(bonus, jackpotNumber)));
        return result;
    }

    private static Integer countMatch(Lotto lotto, JackpotNumber jackpotNumber) {
        long count = lotto.getNumbers().stream()
                .filter(element -> jackpotNumber.getJackpot().getNumbers().contains(element))
                .count();
        return (int) count;
    }
    private static boolean matchBonusNumber(int bonus, JackpotNumber jackpotNumber) {
        if (bonus == jackpotNumber.getBonusNumber()) {
            return true;
        }
        return false;
    }
}
