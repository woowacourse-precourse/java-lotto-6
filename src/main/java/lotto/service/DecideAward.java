package lotto.service;

import lotto.domain.User;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.JackpotNumber;
import lotto.domain.Rank;

public class DecideAward {
    public static Result userResult(User user, JackpotNumber jackpotNumber) {
        Result result = new Result();
        for(Lotto lotto: user.getLottos()) {
            lottoResult(result,lotto,jackpotNumber);
        }
        System.out.println(result);
        return result;
    }

    private static Result lottoResult(Result result, Lotto lotto, JackpotNumber jackpotNumber) {
        result.add(Rank.valueOf(countMatch(lotto, jackpotNumber), matchBonusNumber(lotto, jackpotNumber)));
        return result;
    }

    private static Integer countMatch(Lotto lotto, JackpotNumber jackpotNumber) {
        long count = lotto.getNumbers().stream()
                .filter(element -> jackpotNumber.getJackpot().getNumbers().contains(element))
                .count();
        return (int) count;
    }
    private static boolean matchBonusNumber(Lotto lotto, JackpotNumber jackpotNumber) {
        if ( lotto.getNumbers().contains(jackpotNumber.getBonusNumber())) {
            return true;
        }
        return false;
    }
}
