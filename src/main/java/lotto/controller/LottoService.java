package lotto.controller;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Constant;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Winning;

public class LottoService {
    public static List<Integer> makeRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(Constant.LOTTO_START_NUMBER, Constant.LOTTO_END_NUMBER, Constant.LOTTO_SELECT_NUMBER);
    }

    public static Rank checkLottoRank(Lotto lotto, Winning winning) {
        int match_count = 0;
        boolean bonus_match = false;
        for (int number : lotto.getNumbers()) {
            if (winning.getResult().getNumbers().contains(number)) {
                match_count++;
            }
            if (winning.getBonus() == number) {
                bonus_match = true;
            }
        }

        return matchRankWithCount(match_count, bonus_match);
    }

    private static Rank matchRankWithCount(int match_count, boolean bonus_flag) {
        if (match_count == 6) return Rank.FIRST;
        else if (match_count == 5 && bonus_flag) return Rank.SECOND;
        else if (match_count == 5) return Rank.THIRD;
        else if (match_count == 4) return Rank.FOURTH;
        else if (match_count == 3) return Rank.FIFTH;

        return Rank.LOSE;
    }
}
