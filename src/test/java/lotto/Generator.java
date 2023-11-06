package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class Generator {
    public int generateRandomNumber(){
        return Randoms.pickNumberInRange(0, 45);
    }
}
