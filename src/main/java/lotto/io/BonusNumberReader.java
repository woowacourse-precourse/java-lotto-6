package lotto.io;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BonusNumber {
    public List<Integer> bonusnumber;
    public List bonusNumberGenerator(){
        bonusnumber = Randoms.pickUniqueNumbersInRange(1, 45, 1);
        System.out.println(bonusnumber);
        return bonusnumber;
    }
}
