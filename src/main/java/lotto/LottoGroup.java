package lotto;

import java.util.Collections;
import java.util.ArrayList;

import lotto.Lotto;
import lotto.Input;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGroup {
    private final List<Lotto> lottoGroup = new ArrayList<>();

    public LottoGroup(int lottoCount) {
        getLotto(lottoCount);
    }

    public void getLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNum = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoNum);
            Lotto lotto = new Lotto(lottoNum);
            lottoGroup.add(lotto);
        }

    }

    public List<Lotto> getGroupLotto() {
        return lottoGroup; //LottoGroup의 필드값이 private으로 선언되어있으므로 해당 메소드를 통해 가져와야한다.
    }


}
