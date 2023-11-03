package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoRandomGenerator {
    public Lotto generateRandomLotto(){
        List<Integer> randNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randNumbers);
    }
}
