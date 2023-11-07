package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> makeLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> makeLottoList(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();

        for(int count = 0; count < lottoCount; lottoCount++) {
            lottoList.add(new Lotto(makeLottoNumbers()));
        }
        return lottoList;
    }
}
