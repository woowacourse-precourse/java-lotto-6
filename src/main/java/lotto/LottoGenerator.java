package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private int generateCount;

    private void setGenerateCount(int money) {
        this.generateCount = money / 1000;
        System.out.println(generateCount + "개를 구매했습니다");
    }

    public List<Lotto> buyLotto(int money) {
        setGenerateCount(money);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < generateCount; i++) {
            lottoList.add(createLotto());
        }
        return lottoList;
    }

    private Lotto createLotto () {
        List<Integer> lottoNumber = createLottoNumber();
        Collections.sort(lottoNumber);
        System.out.println(lottoNumber);
        return new Lotto(lottoNumber);
    }

    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
