package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Global {
    private List<Lotto> issuedLottoList;

    public Global() {
        this.issuedLottoList = new ArrayList<>();
    }

    public int getLottoCount(int money) {
        return money / 1000;
    }

    public List<Lotto> getIssuedLottoList(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumberList = getRandomNumber();
            Collections.sort(lottoNumberList);
            Lotto lotto = new Lotto(lottoNumberList);
            issuedLottoList.add(lotto);
        }
        return issuedLottoList;
    }

    private List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
