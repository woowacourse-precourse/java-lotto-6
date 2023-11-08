package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import java.util.ArrayList;
import java.util.List;

public class GenerateLotto {

    private static Lotto generateLotto() {

        try{
            return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        catch (IllegalArgumentException e){
            return generateLotto();
        }

    }

}
