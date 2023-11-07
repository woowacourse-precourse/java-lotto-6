package lotto.domain;

import lotto.Lotto;

import main.java.lotto.domain.WinningLottos;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    //유저와 발행된 로또 사이의 같은 로또 수를 계산한다

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
        }
    }
}

