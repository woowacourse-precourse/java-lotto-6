package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private List<Integer> sortLotto() {
        return makeLotto().stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private Lotto makeToLotto() {
        return new Lotto(sortLotto());
    }
}
