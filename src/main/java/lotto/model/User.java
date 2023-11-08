package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class User {
    List<Lotto> lottoes;

    public User () {
        lottoes = new ArrayList<>();
    }

    public void pickLottoNumber() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        lottoes.add(lotto);
    }
}
