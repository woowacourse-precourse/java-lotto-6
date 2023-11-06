package lotto.domain;

import lotto.Lotto;

import main.java.lotto.domain.WinningLottos;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    //유저와 발행된 로또 사이의 같은 로또 수를 계산한다

    public Integer calculateMatchLottoNumber(UserLotto userLotto, Lotto winningLotto) {
        int count = 0;
        for (int number : winningLotto.getNumbers()) {
            for (int userNumber : userLotto.getUserNumbers().getNumbers()) {
                if (number == userNumber) {
                    count ++;
                }
            }
        }
        return count;
//        if (winnningLotto.getNumbers().contains(user))
//        for (Lotto winningLotto : winningLottos.getWiningLottos()) {
//            System.out.println(userLotto.getUserNumbers().getNumbers());
//            System.out.println(winningLotto.getNumbers());
//            if (winningLotto.getNumbers().contains(userLotto.getUserNumbers().getNumbers())) {
//                count ++;
//            }
        }
//        System.out.println(count);
    }

//            for (Integer number : winningLotto) {
//                if (userLotto.contains(number)) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }


//    public
//    public void match(UserLotto userLotto, main.java.lotto.domain.WinningLottos winningLottos) {
//        for (Lotto lotto: winningLottos.getWinningLotto()){
//            Rank rank =  Rank.valueOf(lotto.countMatchLottoNumber(userLotto), lotto.isContain(userLotto.getBonusNumber()));
//
//}

