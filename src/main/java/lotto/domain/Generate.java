package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Generate {
    public void LottoGenerate(int amountLotto){
        for(int i = 0; i < amountLotto; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }
    }
}
