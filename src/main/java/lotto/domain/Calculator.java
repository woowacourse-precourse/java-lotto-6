package lotto.domain;

import lotto.Lotto;

import main.java.lotto.domain.WinningLottos;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static int calculateMatchLottoNumber(UserLotto userLotto, Lotto winningLotto) {
        int count = 0;
        for (int number : winningLotto.getNumbers()) {
            for (int userNumber : userLotto.getUserNumbers().getNumbers()) {
                if (number == userNumber) {
                    count ++;
                }
            }
        }
        return count;

    }

    public void match(UserLotto userLotto, WinningLottos winninglottos) {
        for (Lotto lotto : winninglottos.getWiningLottos()) {
            Rank rank = Rank.valueOf(calculateMatchLottoNumber(userLotto, lotto), lotto.isContain(userLotto.getBonusNumber()));
            RankContainer rankContainer = new RankContainer();
            rankContainer.incRank(rank);
        }
    }
}

