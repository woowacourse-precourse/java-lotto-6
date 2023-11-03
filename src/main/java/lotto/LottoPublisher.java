package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPublisher {


    public LottoPublisher() {
    }

    public List<Lotto> publishLotto(Long purchaseAmount) {
        long lottoNumber = calculateLottoAmount(purchaseAmount);

        ArrayList<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < lottoNumber; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            Lotto lotto = new Lotto(randomNumbers);
            lottoList.add(lotto);
        }

        return lottoList;
    }

    private long calculateLottoAmount(Long purchaseAmount) {
        return purchaseAmount / 1000;
    }

}
