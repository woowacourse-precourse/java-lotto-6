package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Generator {
    public int generateRandomNumber(){
        return Randoms.pickNumberInRange(0, 45);
    }

    public List<Integer> generate6Nums(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
