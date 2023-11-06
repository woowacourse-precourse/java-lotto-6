package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    public List<Lotto> makeLottoList(int count) {
        List<Lotto> lotto_list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lotto_list.add(makeToLotto());
        }

        return lotto_list;
    }

    private List<Integer> makeLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private Lotto makeToLotto() {
        return new Lotto(makeLotto());
    }
}
